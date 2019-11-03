from flask import Flask, request, send_file
from flask_restful import Resource, Api
import picamera
import multiprocessing as mp
import time
import redis
import base64

import numpy as np
import io

r_redis = redis.Redis(host='redis', port=6379, db=1)
app = Flask(__name__)
api = Api(app)

def get_photo():
    while True:
        PhotoProcessing()
        time.sleep(1)

class PhotoProcessing():
    def __init__(self):
        self.file_name = "image.jpg"
        self.processing()
        self.redis_writer()

    def processing(self):
        stream = io.BytesIO()
        with picamera.PiCamera() as camera:
            camera.rotation = 180
            camera.resolution = (1024, 768)
            camera.start_preview()
            time.sleep(2)
            camera.capture(stream, format='jpeg')
        stream.seek(0)
        self.data = stream
    
    def redis_writer(self):
        encoded_string = base64.b64encode(self.data)
        r_redis.set("img", encoded_string)

class GetPhoto(Resource):
    def get(self):
        """
        Метод для получения фото с Redis
        """
        try:
            file_base64 = bytes(r_redis.get("img"))
            in_memory_file = io.BytesIO(file_base64)
            data = np.frombuffer(in_memory_file.getvalue(), dtype=np.uint8)
            return send_file(data, mimetype='image/jpg')
        except:
            return {"status": "exception"}

api.add_resource(GetPhoto, '/get_photo')

if __name__ == '__main__':
    p = mp.Process(target=get_photo)
    p.start()
    app.run(host='0.0.0.0', debug=False)
