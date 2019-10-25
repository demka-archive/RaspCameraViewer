using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace RaspCamera
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public int counter;
        public MainWindow()
        {
            InitializeComponent();
            TextKoshkas.Text = "";
            counter = 0;
        }

        private void Button_Click(object sender, RoutedEventArgs e) {


            DispatcherTimer Timer = new DispatcherTimer();
            Timer.Tick += new EventHandler(KoshkaWriter_Tick);
            Timer.Interval = new TimeSpan(0, 0, 0, 0,1);
            Timer.Start();

  
        }

        private void KoshkaWriter_Tick(object sender, EventArgs e)
        {
            OutClass meow = new OutClass(counter);
            TextKoshkas.Text += meow.GetCats();
            counter += 1;
            CommandManager.InvalidateRequerySuggested();
        }
    }
}
