package mr_online;
public class faculty {
    private String name;
    private int code;
    private int numbers_of_years;
    private int numbers_of_subjects;
    private subject [] subjects=new subject[numbers_of_subjects];
    private int Scounter=0;
    
    public faculty(){
    }
    
    public faculty(String name,int code){
        this.name=name;
        this.code=code;
    }    
    
    public faculty(String name,int code,int numbers_of_years,int numbers_of_subjects){
        this.name=name;
        this.code=code;
        this.numbers_of_subjects=numbers_of_subjects;
        this.numbers_of_years=numbers_of_years;
    }
    
    // setters
    public void setname(String name) {
        this.name = name;
    }
    
    public void setcode(int code) {
            this.code = code;
        }
    
    public void setNyears(int numbers_of_years) {
        this.numbers_of_years = numbers_of_years;
    }

    public void setNsubjects(int numbers_of_subjects){
        this.numbers_of_subjects = numbers_of_subjects;
    }
    
    public void addSubject(String name,int code,double hours,double mark){
        if(Scounter<=subjects.length-1){
            subjects[Scounter]=new subject(name,code,hours,mark);
            Scounter++;
        }
        else
            System.out.println("ERROR:overload!");
    }
    
    // getters
    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getNyears() {
        return numbers_of_years;
    }

    public int getNsubjects() {
        return numbers_of_subjects;
    }

    public void getSubjects() {
        if(Scounter==0)
            System.out.print("");
        else{
            for(int i=0;i<=Scounter;i++){
                System.out.println("Subject "+(i+1)+"\n"
                        + "name: "+subjects[i].getName()+"\n"
                                + "code: "+subjects[i].getCode()+"\n"
                                        + "hours: "+subjects[i].getHours()+"\n"
                                                + "total mark: "+subjects[i].getTotalMark());
                System.out.println("________________________");
            }
        }
    }
    
    // methods
    public void deleteSubject(int code){
        if (Scounter==0)
            System.out.println("there is no subjects to delete!");
        else{
            for(int i=0;i<=Scounter;i++){
                if(subjects[i].getCode()==code){
                    for(int j=i;j<Scounter;j++){
                        subjects[j]=subjects[j+1];
                    }
                    System.out.println("subject deleted successfully");
                }
                else
                    System.out.println("can't find subject code!");
            }
        }
    }
    
    public void print(){
        System.out.println("name: "+name+"\n"
                + "code: "+code+"\n"
                        + "number of years: "+this.numbers_of_years+"\n"
                                + "number of subjects: "+this.numbers_of_subjects);
        if(Scounter>0)
            getSubjects();
        else
            System.out.println("there is no subject's details avilable now!");
    }
}
