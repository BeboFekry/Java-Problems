package mr_online;
public class subject {
    public String name;
    public int code;
    public double hours;
    public double totalMark;
    
    public subject(){
    }
    public subject(String name,int code){
        this.name=name;
        this.code=code;
    }
    public subject(String name,int code,double hours,double totalMark){
        this.name=name;
        this.code=code;
        this.hours=hours;
        this.totalMark=totalMark;
    }
    // setters
    public void setName(String name){
        this.name=name;
    }
    public void setCode(int code){
        this.code=code;
    }
    public void setHours(double hours){
        this.hours=hours;
    }
    public void setTotalMark(double mark){
        totalMark=mark;
    }
    // getters
    public String getName(){
        return this.name;
    }
    public int getCode(){
        return this.code;
    }
    public double getHours(){
        return this.hours;
    }
    public double getTotalMark(){
        return this.totalMark;
    }
    
}

