package mr_online;
public class employee extends person{
    private double salary;
    private int hours;
    private String job;
    private int code;
    
    public employee(){
    }
    public employee(String name,int code){
        this.name=name;
        this.code=code;
    }
    public employee(String name,int code,int age,String location,char gender,int phone,String job,double salary,int hours){
        this.name=name;
        this.code=code;
        this.age=age;
        this.gender=gender;
        this.location=location;
        this.phone=phone;
        this.salary=salary;
        this.hours=hours;
        this.job=job;
    }
    //setters
    public void setSalary(double s){
        this.salary=s;
    }
    
    public void setHours(int h){
        this.hours=h;
    }
    
    public void setJob(String job){
        this.job=job;
    }
    
    public void setCode(int code){
        this.code=code;
    }
    
    //getters
    public double getSalary(){
        return this.salary;
    }
    
    public int getCode(){
        return this.code;
    }
    
    public int getJours(){
        return this.hours;
    }
    
    public String getJob(){
        return this.job;
    }
    // methods
    public void print(){
        System.out.println("name: "+this.name+"\n"
                + "code: "+this.code+
                "\nage: "+this.age+
                "\nlocation: "+this.location+
                "\ngender: "+this.gender+
                "\nphone: "+this.phone+"\n"
                        + "salary: "+this.salary+"\n"
                                + "hours: "+this.hours+"\n"
                                        + "job: "+this.job);
    }
}
