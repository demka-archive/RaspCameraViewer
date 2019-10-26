from flask import Flask, request, send_file
from flask_restful import Resource, Api
import picamera
import time
import uuid


app = Flask(__name__)
api = Api(app)

class PhotoProcessing():
    def __init__(self):
        self.result = False
        self.file_name = str(uuid.uuid1())+".jpg"
        self.processing()

    def processing(self):

        #TODO Пилить в Async в Redis, последний результат отдавать в Flask
        with picamera.PiCamera() as camera:
            camera.rotation = 180
            camera.resolution = (1024, 768)
            camera.start_preview()
            time.sleep(2)
            camera.capture(self.file_name)
        self.result = True


class GetPhoto(Resource):
    def get(self):
        """
        Метод для получения фото с камеры Raspberry Pi
        """
        obj = PhotoProcessing()
        if obj.result == True:
            return send_file(obj.file_name, mimetype='image/png')
        else:
            return {"status": "exception"}

api.add_resource(GetPhoto, '/get_photo')

if __name__ == '__main__':
    app.run(host='192.168.5.171', debug=False)
