package interthreadcommunication;

class WhiteBoard{
    int data = 0;
    boolean flag = true;
    synchronized void write(int i){
        while(!flag) {
            try{wait();}catch(Exception e){}
        }
        data = i;
        flag = false;
        
        notify();
    }
    synchronized int read(){
        while(flag){
            try{wait();}catch(Exception e){}
        }
        flag = true;
        notify();
        return data;
    }
}
class Teacher extends Thread{
    WhiteBoard wb;
    Teacher(WhiteBoard s){
        wb = s;
    }
    @Override
    public void run(){
        int i=1;
        while(true){
            wb.write(i);
            System.out.println("Teacher Writing " + i);
            i++;
        }
    }
}

class Student extends Thread{
    WhiteBoard wb;
    Student(WhiteBoard s){
        wb = s;
    }
    @Override
    public void run(){
        while(true){
            System.out.println("Student Reading "+ wb.read());
        }
    }
}

public class InterThreadCommunication {

    public static void main(String[] args) {
        WhiteBoard wb = new WhiteBoard();
        Teacher t = new Teacher(wb);
        Student s = new Student(wb);
        t.start();
        s.start();
    }
}
