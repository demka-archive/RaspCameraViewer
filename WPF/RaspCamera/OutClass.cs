using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RaspCamera
{
    public class OutClass 
    {
        public int number;
        public OutClass(int click)
        {
            number = click;
            this.GetCats();
        }

        public string GetCats()
        {
            return "Cat" + this.number.ToString();
        }


    }
}
