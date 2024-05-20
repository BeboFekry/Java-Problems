package mr_online;

public class student extends person{
    private int year;
    private int code;
    private int facultyCode;
    private boolean graduated=false;
    private int Nsubjects; // its passing subjects
    private subject [] subjects=new subject[Nsubjects];
    private int counter=0;
    
    public student(){
    }
    
    public student(String name,int code,int facultyCode){
        this.name=name;
        this.code=code;
        this.facultyCode=facultyCode;
    }
    
    public student(String name,int code,int age,String location,char gender,int phone,int year){
        this.name=name;
        this.code=code;
        this.age=age;
        this.gender=gender;
        this.location=location;
        this.phone=phone;
    }
    
    // setters
    public void setyear(int yesr){
        this.year=year;
    }
    
    public void setfacultyCode(int facultyCode){
        this.facultyCode=facultyCode;
    }
    
    public void setgraduated(boolean gradu){
        this.graduated=gradu;
    }
    public void setNsubjects(int numbers_of_subjects){
        this.Nsubjects = numbers_of_subjects;
    }
    
    public void addsubject(String name,int code,double hours,double mark){
        if(counter<=subjects.length-1){
            if(counter==0)
                subjects[0]=new subject(name,code,hours,mark);
            else
                subjects[counter]=new subject(name,code,hours,mark);
            counter++;
        }
        else
            System.out.println("ERROR:overload!");
    }
    
    public void setcode(int code){
        this.code=code;
    }
    
    // getters
    public int getcode(){
        return code;
    }
    
    public int getfacultyCode(){
        return facultyCode;
    }
    
    public int getyear(){
        return year;
    }
    
    public void getSubjects() {
        System.out.println(subjects);
    }
    // methods
    public void print(){
        System.out.println("name: "+this.name+"\n"
                + "code: "+this.code+
                "\nage: "+this.age+
                "\nlocation: "+this.location+
                "\ngender: "+this.gender+
                "\nphone: "+this.phone+"\n"
                        + "faculty code: "+this.facultyCode+"\n"
                                + "year: "+this.year);
    }
}
