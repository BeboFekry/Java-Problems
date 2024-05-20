package mr_online;
public class person {
    public String name;
    public int age;
    public String location;
    public char gender;
    public int phone;
    
    public person(){
    }
    public person(String name,int age,String location,char gender,int phone){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.location=location;
        this.phone=phone;
    }
    
    // setters
    public void setname(String name){
        this.name=name;
    }
    public void setage(int age){
        this.age=age;
    }
    public void setgender(char gender){
        this.gender=gender;
    }
    public void setlocation(String location){
        this.location=location;
    }
    public void setphone(int phone){
        this.phone=phone;
    }
    // getters
    public String getname(){
        return name;
    }
    public String getlocaiton(){
        return location;
    }
    public int getage(){
        return age;
    }
    public int getphone(){
        return phone;
    }
    public char getgender(){
        return gender;
    }
    //printing all attributes
//    public void print(){
//        System.out.println("name: "+this.name+
//                "\nage: "+this.age+
//                "\nlocation: "+this.location+
//                "\ngender: "+this.gender+
//                "\nphone: "+this.phone);
//    }
}
