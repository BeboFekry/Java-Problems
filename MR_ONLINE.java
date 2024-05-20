package mr_online;
import java.util.Scanner;
public class MR_ONLINE{
    static int fCounter;
    static int sCounter=0;
    static int eCounter=0;
    public static void main(String[] args) {
        new myFrame().setVisible(true);
        Scanner input=new Scanner(System.in);
        //numbers of ... 
        int nfaculty=10;
        int nemployee=100;
        int nstudent=1000;
        student st[]=new student[nstudent];
        employee emp []=new employee[nemployee];
        faculty fac[]=new faculty[nfaculty];
        fCounter=0;
        sCounter=0;
        eCounter=0;
        System.out.println("enter \"0\" to close program"+
                "\n\"1\" to put data"+
                "\n\"2\" to get data");
        // choice for input or output data
        int choice=input.nextInt();
        while (choice !=0){
            switch(choice){
                // close program
                case 0->{
                    break;
                }
                // put a user data
                case 1->{
                    line();
                    System.out.println("enter: \"0\" to get back to the last menue"+
                            "\n\"1\" faculty"+
                            "\n\"2\" employee"+
                            "\n\"3\" Student");
                    // choice2 for any type of data input
                    int choice2 =input.nextInt();
                    switch(choice2){
                        // back
                        case 0->{
                            break;
                        }
                        // into faculuty
                        case 1 ->{
                            line();
                            System.out.println("enter: \"0\" to get back to the last menue"+
                            "\n\"1\" to create a new faculty"+
                            "\n\"2\" to update an existing faculuty");
                            // choice3 for create or update a faculuty
                            int choice3=input.nextInt();
                            while(choice3!=0){
                                switch(choice3){
                                    // back
                                    case 0->{
                                        break;
                                    }
                                    // create new faculty
                                    case 1->{
                                        if(fCounter<=nfaculty-1){
                                            System.out.print("name: ");
                                            String name=input.next();
                                            System.out.print("code: ");
                                            int code=input.nextInt();
                                            if(!check(fac,code))
                                                fac[fCounter]=new faculty(name,code);
                                            else{
                                                System.out.println("ERROR:there is a faculty having the same code already:try to re enter an another unused code!");
                                                System.out.print("code: ");
                                                code=input.nextInt();
                                                if(!check(fac,code))
                                                    fac[fCounter]=new faculty(name,code);
                                                else{
                                                    System.out.println("ERROR:there is a faculty having the same code already!");
                                                    break;
                                                }
                                            }
                                            System.out.print("number of years: ");
                                            fac[fCounter].setNyears(input.nextInt());
                                            System.out.print("number of subjects: ");
                                            int num=input.nextInt();
                                            if(num<=0){
                                                do{
                                                    System.out.println("ERROR:number of subjects must be postive number!");
                                                    System.out.print("number of subjects: ");
                                                    num=input.nextInt();
                                                }while(num<=0);
                                            }
                                            fac[fCounter].setNsubjects(num);
                                            System.out.println("**enter \"x\" to skip input**");
                                            for(int i=0;i<fac[fCounter].getNsubjects();i++){
                                                System.out.print("subject"+(i+1)+" name: ");
                                                String sub=input.next();
                                                if(sub.equals("x"))
                                                    break;
                                                System.out.print("code "+(i+1)+": ");
                                                int subCode=input.nextInt();
                                                System.out.print("hours"+(i+1)+": ");
                                                double hours=input.nextDouble();
                                                System.out.print("total mark"+(i+1)+": ");
                                                double mark=input.nextDouble();
                                                fac[fCounter].addSubject(sub,subCode,mark,hours);
                                            }
                                            
                                            fCounter++;
                                        }
                                        else
                                            System.out.println("ERROR:overload faculties!");
                                    }
                                    // update an existing faculty
                                    case 2->{
                                        if(fCounter==0){
                                            System.out.println("there is no faculties to update!");
                                            break;
                                        }
                                        System.out.print("enter the faculty code to edit: ");
                                        int code=input.nextInt();
                                        for(int i=0;i<fCounter;i++){
                                            if(fac[i].getCode()==code){
                                                line();
                                                System.out.println("enter \"0\" to get back to the last menue\n"
                                                        + "\"1\" to edit the name\n"
                                                        + "\"2\" to edit the code\n"
                                                        + "\"3\" to edit the number of subjects\n"
                                                        + "\"4\" to edit the number of years\n"
                                                        + "\"5\" to add subject\n"
                                                        + "\"6\" to delete subject\n"
                                                        + "\"7\" to delete faculty");
                                                int choice4=input.nextInt(); // for editing faculty
                                                switch(choice4){
                                                    case 0->{
                                                        break;
                                                    }
                                                    // edit name
                                                    case 1->{
                                                        System.out.print("enter the new faculty's name: ");
                                                        fac[i].setname(input.next());
                                                    }
                                                    // edit code
                                                    case 2->{
                                                        System.out.print("enter the new faculty's code: ");
                                                        fac[i].setcode(input.nextInt());
                                                    }
                                                    // no. of subjects
                                                    case 3->{
                                                        System.out.print("enter the new faculty's number of subjects: ");
                                                        fac[i].setNsubjects(input.nextInt());
                                                    }
                                                    // no. of years
                                                    case 4->{
                                                        System.out.print("enter the new faculty's number of years: ");
                                                        fac[i].setNyears(input.nextInt());
                                                    }
                                                    // add subject
                                                    case 5->{
                                                        System.out.print("enter the subject name: ");
                                                        String newName=input.next();
                                                        System.out.print("enter the subject code: ");
                                                        int newCode=input.nextInt();
                                                        System.out.print("enter the subject hours: ");
                                                        double newHours=input.nextDouble();
                                                        System.out.print("enter the subject total marks: ");
                                                        double newMark=input.nextDouble();
                                                        fac[i].addSubject(newName,newCode,newHours,newMark);
                                                    }
                                                    // delete subject
                                                    case 6->{
                                                        System.out.print("faculty code: ");
                                                        int fCode=input.nextInt();
                                                        for(int j=0;j<=fCounter;j++){
                                                            if(fac[j].getCode()==fCode){
                                                                System.out.print("subject code: ");
                                                                fac[j].deleteSubject(code);
                                                            }
                                                            else
                                                                System.out.println("coan't find faculty code!");
                                                        }
                                                    }
                                                    // delete a faculty
                                                    case 7->{
                                                        System.out.println("the faculty will deleted forever if you want to continue enter \"1\", if not enter \"0\"");
                                                        int delChoice=input.nextInt();
                                                        if(delChoice==1){
                                                            for(int j=i;j<fCounter-1;j++){
                                                                fac[j]=fac[j+1];
                                                            }
                                                            fCounter--;
                                                            System.out.println("deletion success");
                                                        }
                                                        else if(delChoice==0){
                                                            System.out.println("the deletion have canceled");
                                                            break;
                                                        }
                                                        else
                                                            System.out.println("ERROR:invalid input!");
                                                    }
                                                    default->{
                                                        System.out.println("ERROR:invalid input!");
                                                    }
                                                }
                                                break;
                                            }
                                            else if(i==fCounter-1)
                                                System.out.println("can't find faculty code!");
                                        }
                                    }
                                    default ->{
                                        System.out.println("ERROR:invalid input!");
                                    }
                                } // end faculty switch
                                line();
                                System.out.println("enter: \"0\" to get back to the last menue"+
                                "\n\"1\" to create a new faculty"+
                                "\n\"2\" to update an existing faculuty");
                                // choice3 for create or update a faculuty
                                choice3=input.nextInt();
                            }
                        } // end faculty case1
                        
                        // into employee
                        case 2->{
                            line();
                            System.out.println("enter: \"0\" to get back to the last menue"+
                            "\n\"1\" to create a new employee"+
                            "\n\"2\" to update an existing employee");
                            // choice5 for create or update a employee
                            int choice5=input.nextInt();
                            while(choice5!=0){
                                switch(choice5){
                                    // back
                                    case 0->{
                                        break;
                                    }
                                    // create new employee
                                    case 1->{
                                        if(eCounter<=nemployee-1){
                                            System.out.print("name: ");
                                            String name=input.next();
                                            System.out.print("code: ");
                                            int code=input.nextInt();
                                            if(!check(emp,code))
                                                emp[eCounter]=new employee(name,code);
                                            else{
                                                System.out.println("ERROR:there is an employee having the same code already:try to re enter an another unused code!");
                                                System.out.print("code: ");
                                                code=input.nextInt();
                                                if(!check(emp,code))
                                                    emp[eCounter]=new employee(name,code);
                                                else{
                                                    System.out.println("ERROR:there is an employee having the same code already!");
                                                    break;
                                                }
                                            }
                                            System.out.print("age: ");
                                            emp[eCounter].setage(input.nextInt());
                                            System.out.print("gender: ");
                                            emp[eCounter].setgender(input.next().charAt(0));
                                            System.out.print("location: ");
                                            emp[eCounter].setlocation(input.next());
                                            System.out.print("phone: ");
                                            emp[eCounter].setphone(input.nextInt());
                                            System.out.print("job: ");
                                            emp[eCounter].setJob(input.next());
                                            System.out.print("salary: ");
                                            emp[eCounter].setSalary(input.nextDouble());
                                            System.out.print("hours: ");
                                            emp[eCounter].setHours(input.nextInt());
                                            eCounter++;
                                        }
                                        else
                                            System.out.println("ERROR:overload employees!");
                                    }
                                    // update an existing employee
                                    case 2->{
                                        if(eCounter==0){
                                            System.out.println("there is no employees to update!");
                                            break;
                                        }
                                        System.out.print("enter the employee code to edit: ");
                                        int code=input.nextInt();
                                        for(int i=0;i<eCounter;i++){
                                            if(emp[i].getCode()==code){
                                                line();
                                                System.out.println("enter \"0\" to get back to the last menue\n"
                                                        + "\"1\" to edit the name\n"
                                                        + "\"2\" to edit the code\n"
                                                        + "\"3\" to edit the age\n"
                                                        + "\"4\" to edit the location\n"
                                                        + "\"5\" to edit gender\n"
                                                        + "\"6\" to edit phone\n"
                                                        + "\"7\" to edit salary\n"
                                                        + "\"8\" to edit job\n"
                                                        + "\"9\" to edit hours\n"
                                                        + "\"10\" to delete an employee");
                                                int choice4=input.nextInt(); // for editing employee data
                                                switch(choice4){
                                                    case 0->{
                                                        break;
                                                    }
                                                    // edit name
                                                    case 1->{
                                                        System.out.print("enter the new employee's name: ");
                                                        emp[i].setname(input.next());
                                                    }
                                                    // edit code
                                                    case 2->{
                                                        System.out.print("enter the new employee's code: ");
                                                        emp[i].setCode(input.nextInt());
                                                    }
                                                    // age
                                                    case 3->{
                                                        System.out.print("enter the new employee's age: ");
                                                        emp[i].setage(input.nextInt());
                                                    }
                                                    // locaiton
                                                    case 4->{
                                                        System.out.print("enter the new location: ");
                                                        emp[i].setlocation(input.next());
                                                    }
                                                    // gender
                                                    case 5->{
                                                        System.out.print("enter the new employee's gender: ");
                                                        emp[i].setgender(input.next().charAt(0));
                                                    }
                                                    // phone
                                                    case 6->{
                                                        System.out.print("enter the new employee's phone: ");
                                                        emp[i].setphone(input.nextInt());
                                                    }
                                                    // salary
                                                    case 7->{
                                                        System.out.print("enter the new employee's salary: ");
                                                        emp[i].setSalary(input.nextDouble());
                                                    }
                                                    // job
                                                    case 8->{
                                                        System.out.print("enter the new employee's job: ");
                                                        emp[i].setJob(input.next());

                                                    }
                                                    // hours
                                                    case 9->{
                                                        System.out.print("enter the new employee's hours: ");
                                                        emp[i].setHours(input.nextInt());
                                                    }
                                                    // delete an employee
                                                    case 10->{
                                                        System.out.println("the employee will deleted forever if you want to continue enter \"1\", if not enter \"0\"");
                                                        int delChoice=input.nextInt();
                                                        if(delChoice==1){
                                                            for(int j=i;j<eCounter-1;j++){
                                                                emp[j]=emp[j+1];
                                                            }
                                                            eCounter--;
                                                            System.out.println("deletion success");
                                                        }
                                                        else if(delChoice==0){
                                                            System.out.println("the deletion have canceled");
                                                            break;
                                                        }
                                                        else
                                                            System.out.println("ERROR:invalid input!");
                                                    }
                                                    default->{
                                                        System.out.println("ERROR:invalid input!");
                                                    }
                                                }
                                                break;
                                            }
                                            else if(i==eCounter-1)
                                                System.out.println("can't find employee code!");
                                        }
                                    }
                                    default ->{
                                        System.out.println("ERROR:invalid input!");
                                    }
                                } // end employee switch
                                line();
                                System.out.println("enter: \"0\" to get back to the last menue"+
                                "\n\"1\" to create a new employee"+
                                "\n\"2\" to update an existing employee");
                                // choice5 for create or update a employee
                                choice5=input.nextInt();
                            }
                        } // end employee case2
                        
                        // into student
                        case 3->{
                            line();
                            System.out.println("enter: \"0\" to get back to the last menue"+
                            "\n\"1\" to create a new student"+
                            "\n\"2\" to update an existing student");
                            // choice6 for create or update a student
                            int choice6=input.nextInt();
                            while(choice6!=0){
                                switch(choice6){
                                    // back
                                    case 0->{
                                        break;
                                    }
                                    // create new student
                                    case 1->{
                                        if(sCounter<=nstudent-1){
                                            System.out.print("name: ");
                                            String name=input.next();
                                            System.out.print("code: ");
                                            int code=input.nextInt();
                                            if(check(st,code)){
                                                System.out.println("ERROR:there is an student having the same code already:try to re enter an another unused code!");
                                                System.out.print("code: ");
                                                code=input.nextInt();
                                                if(check(st,code)){
                                                    System.out.println("test");
                                                    System.out.println("ERROR:there is an student having the same code already!");
                                                    break;
                                                }
                                                else{}
                                            }
                                            System.out.print("student's faculty code: ");
                                            int code2=input.nextInt();
                                            if(check(fac,code2))
                                                st[sCounter]=new student(name,code,code2);
                                            else{
                                                System.out.println("ERROR:the faculty code doesn't exist:try to re enter the faculty code!");
                                                System.out.print("student's faculty code: ");
                                                code2=input.nextInt();
                                                if(check(fac,code2))
                                                    st[sCounter]=new student(name,code,code2);
                                                else{
                                                    System.out.println("ERROR:the faculty code doesn't exist!");
                                                    break;
                                                }
                                            }
                                            System.out.print("age: ");
                                            st[sCounter].setage(input.nextInt());
                                            System.out.print("gender: ");
                                            st[sCounter].setgender(input.next().charAt(0));
                                            System.out.print("location: ");
                                            st[sCounter].setlocation(input.next());
                                            System.out.print("phone: ");
                                            st[sCounter].setphone(input.nextInt());
                                            System.out.print("year: ");
                                            int year=input.nextInt();
                                            if(fac[search(fac,code2)].getNyears()>=year)
                                                st[sCounter].setyear(year);
                                            else{
                                                System.out.println("ERROR:the faculty of \""+fac[search(fac,code2)].getName()+"\" is only \""+fac[search(fac,code2)].getNyears()+"\" years,so student con't be in the year "+year+"!:\ntry to re enter the student's year..");
                                                System.out.print("year: ");
                                                year=input.nextInt();
                                                if(fac[search(fac,code2)].getNyears()>=year)
                                                    st[sCounter].setyear(year);
                                                else
                                                    System.out.println("ERROR:the faculty of \""+fac[search(fac,code2)].getName()+"\" is only \""+fac[search(fac,code2)].getNyears()+"\" years,so student con't be in the year "+year+"!");
                                            }
                                            sCounter++;
                                        }
                                        else
                                            System.out.println("ERROR:overload students!");
                                    }
                                    // update an existing student
                                    case 2->{
                                        if(sCounter==0){
                                            System.out.println("there is no students to update!");
                                            break;
                                        }
                                        System.out.print("enter the student code to edit: ");
                                        int code=input.nextInt();
                                        for(int i=0;i<sCounter;i++){
                                            if(st[i].getcode()==code){
                                                line();
                                                System.out.println("enter \"0\" to get back to the last menue\n"
                                                        + "\"1\" to edit the name\n"
                                                        + "\"2\" to edit the code\n"
                                                        + "\"3\" to edit the age\n"
                                                        + "\"4\" to edit the location\n"
                                                        + "\"5\" to edit gender\n"
                                                        + "\"6\" to edit phone\n"
                                                        + "\"7\" to edit year\n"
                                                        + "\"8\" to edit student's faculty code"
                                                        + "\"9\" if graduated?\n"
                                                        + "\"10\" to delete a student");
                                                int choice4=input.nextInt(); // for editing student data
                                                switch(choice4){
                                                    case 0->{
                                                        break;
                                                    }
                                                    // edit name
                                                    case 1->{
                                                        System.out.print("enter the new student's name: ");
                                                        st[i].setname(input.next());
                                                    }
                                                    // edit code
                                                    case 2->{
                                                        System.out.print("enter the new student's code: ");
                                                        st[i].setcode(input.nextInt());
                                                    }
                                                    // age
                                                    case 3->{
                                                        System.out.print("enter the new student's age: ");
                                                        st[i].setage(input.nextInt());
                                                    }
                                                    // locaiton
                                                    case 4->{
                                                        System.out.print("enter the new student's location: ");
                                                        st[i].setlocation(input.next());
                                                    }
                                                    // gender
                                                    case 5->{
                                                        System.out.print("enter the new student's gender: ");
                                                        st[i].setgender(input.next().charAt(0));
                                                    }
                                                    // phone
                                                    case 6->{
                                                        System.out.print("enter the new student's phone: ");
                                                        st[i].setphone(input.nextInt());
                                                    }
                                                    // yaer
                                                    case 7->{
                                                        System.out.print("enter the new student's year: ");
                                                        int year=input.nextInt();
                                                        if(year>fac[i].getNyears())
                                                            System.out.println("ERROR:");
                                                        st[i].setyear(input.nextInt());
                                                    }
                                                    // faculty code
                                                    case 8->{
                                                        System.out.print("enter the new student's faculty code: ");
                                                        int testcode=input.nextInt();
                                                        if(check(fac,testcode))
                                                            st[i].setfacultyCode(testcode);
                                                        else
                                                            System.out.println("ERROR:faculty code doesn't exist");
                                                    }
                                                    // is graduated
                                                    case 9->{
                                                        System.out.print("enter \"1\" if the student have graduated, or \"0\" if still not");
                                                        int n=input.nextInt();
                                                        if(n==0)
                                                            st[i].setgraduated(false);
                                                        else if(n==1)
                                                            st[i].setgraduated(true);
                                                        else
                                                            System.out.println("ERROR:invalid input!");
                                                    }
                                                    // delete a student
                                                    case 10->{
                                                        System.out.println("the student will deleted forever if you want to continue enter \"1\", if not enter \"0\"");
                                                        int delChoice=input.nextInt();
                                                        if(delChoice==1){
                                                            for(int j=i;j<sCounter-1;j++){
                                                                st[j]=st[j+1];
                                                            }
                                                            sCounter--;
                                                            System.out.println("deletion success");
                                                        }
                                                        else if(delChoice==0){
                                                            System.out.println("the deletion have canceled");
                                                            break;
                                                        }
                                                        else
                                                            System.out.println("ERROR:invalid input!");
                                                    }
                                                    default->{
                                                        System.out.println("ERROR:invalid input!");
                                                    }
                                                }
                                                break;
                                            }
                                            else if(i==sCounter-1)
                                                System.out.println("can't find student code!");
                                        }
                                    }
                                    default ->{
                                        System.out.println("ERROR:invalid input!");
                                    }
                                } // end student switch
                                line();
                                System.out.println("enter: \"0\" to get back to the last menue"+
                                                        "\n\"1\" to create a new student"+
                                                            "\n\"2\" to update an existing student");
                                // choice6 for create or update a student
                                choice6=input.nextInt();
                            }
                        } // end student case3
                        default ->{
                            System.out.println("ERROR:invalid input!");
                        }
                    } // ending input switch
                }
                // get a user data
                case 2->{
                    line();
                    System.out.println("enter \"0\" to get back to the last menue\n"
                            + "\"1\" to search for an entity\n"
                            + "\"2\" to print");
                    int choice2=input.nextInt();
                    while(choice2!=0){
                        switch(choice2){
                            case 0->{
                                break;
                            }
                            case 1->{
                                line();
                                System.out.println("enter \"0\" to get back to the last menue\n"
                                        + "\"1\" to search for faculty\n"
                                        + "\"2\" to search for employee\n"
                                        + "\"3\" to search for student");
                                int choice3=input.nextInt();
                                while (choice3!=0){
                                    switch(choice3){
                                        case 0->{
                                            break;
                                        }
                                        // search for faculties
                                        case 1->{
                                            line();
                                            System.out.println("enter \"0\" to get back to the last menue\n"
                                                    + "\"1\" to search by code(recommended)\n"
                                                    + "\"2\" to search by name");
                                            int choice4=input.nextInt();
                                            while(choice4!=0){
                                                switch(choice4){
                                                    case 0->{
                                                        break;
                                                    }
                                                    // search faculty by code
                                                    case 1->{
                                                        System.out.print("enter the code to search: ");
                                                        int code=input.nextInt();
                                                        int x=search(fac,code);
                                                        if(x==-1){
                                                            System.out.println("faculty code doesn't exist!");
                                                        }
                                                        else
                                                            fac[x].print();
                                                    }
                                                    // search faculty by name
                                                    case 2->{
                                                        System.out.print("enter the name to search: ");
                                                        String searchName=input.next();
                                                        for (int i=0;i<fCounter;i++){
                                                            if(fac[i].getName().equals(searchName)){
                                                                fac[i].print();
                                                                break;
                                                            }
                                                            if(i==fCounter-1)
                                                                System.out.println("faculty name doesn't exist!");
                                                        }
                                                    }
                                                    default->{
                                                        System.out.println("ERROR:invalid input!");
                                                    }
                                                }
                                                line();
                                                System.out.println("enter \"0\" to get back to the last menue\n"
                                                    + "\"1\" to search by code(recommended)\n"
                                                    + "\"2\" to search by name");
                                                choice4=input.nextInt();
                                            }
                                        } //ending case1 searcgh for faculty 
                                        // search for employees
                                        case 2->{
                                            line();
                                            System.out.println("enter \"0\" to get back to the last menue\n"
                                                    + "\"1\" to search by code(recommended)\n"
                                                    + "\"2\" to search by name");
                                            int choice4=input.nextInt();
                                            while(choice4!=0){
                                                switch(choice4){
                                                    case 0->{
                                                        break;
                                                    }
                                                    // search employee by code
                                                    case 1->{
                                                        System.out.print("enter the code to search: ");
                                                        int code=input.nextInt();
                                                        int x=search(emp,code);
                                                        if(x==-1){
                                                            System.out.println("employee code doesn't exist!");
                                                        }
                                                        else
                                                            emp[x].print();
                                                    }
                                                    // search employee by name
                                                    case 2->{
                                                        System.out.print("enter the name to search: ");
                                                        String searchName=input.next();
                                                        for (int i=0;i<eCounter;i++){
                                                            if(emp[i].getname().equals(searchName)){
                                                                emp[i].print();
                                                                break;
                                                            }
                                                            if(i==eCounter-1)
                                                                System.out.println("employee name doesn't exist!");
                                                        }
                                                    }
                                                    default->{
                                                        System.out.println("ERROR:invalid input!");
                                                    }
                                                }
                                                line();
                                                System.out.println("enter \"0\" to get back to the last menue\n"
                                                    + "\"1\" to search by code(recommended)\n"
                                                    + "\"2\" to search by name");
                                                choice4=input.nextInt();
                                            }
                                        } // end case2 search for employee
                                        // search for students
                                        case 3->{
                                            line();
                                            System.out.println("enter \"0\" to get back to the last menue\n"
                                                    + "\"1\" to search by code(recommended)\n"
                                                    + "\"2\" to search by name");
                                            int choice4=input.nextInt();
                                            while(choice4!=0){
                                                switch(choice4){
                                                    case 0->{
                                                        break;
                                                    }
                                                    // search student by code
                                                    case 1->{
                                                        System.out.print("enter the code to search: ");
                                                        int code=input.nextInt();
                                                        int x=search(st,code);
                                                        if(x==-1){
                                                            System.out.println("student code doesn't exist!");
                                                        }
                                                        else
                                                            st[x].print();
                                                    }
                                                    // search student by name
                                                    case 2->{
                                                        System.out.print("enter the name to search: ");
                                                        String searchName=input.next();
                                                        for (int i=0;i<sCounter;i++){
                                                            if(st[i].getname().equals(searchName)){
                                                                st[i].print();
                                                                break;
                                                            }
                                                            if(i==sCounter-1)
                                                                System.out.println("student name doesn't exist!");
                                                        }
                                                    }
                                                    default->{
                                                        System.out.println("ERROR:invalid input!");
                                                    }
                                                }
                                                line();
                                                System.out.println("enter \"0\" to get back to the last menue\n"
                                                    + "\"1\" to search by code(recommended)\n"
                                                    + "\"2\" to search by name");
                                                choice4=input.nextInt();
                                            }
                                        }
                                        default ->{
                                            System.out.println("ERROR:invalid input");
                                        }
                                    }
                                    line();
                                    System.out.println("enter \"0\" to get back to the last menue\n"
                                        + "\"1\" to search for faculty\n"
                                        + "\"2\" to search for employee\n"
                                        + "\"3\" to search for student");
                                    choice3=input.nextInt();
                                }
                            }
                            // printing
                            case 2->{
                                line();
                                System.out.println("enter \"0\" to get back to the last menue\n"
                                        + "\"1\" to print faculties informations\n"
                                        + "\"2\" to print employees informations\n"
                                        + "\"3\" to print students informations");
                                int printChoice=input.nextInt();
                                switch(printChoice){
                                    case 0->{
                                        break;
                                    }
                                    // pring faculties
                                    case 1->{
                                        if(fCounter==0)
                                            System.out.println("there is no faculties yet!");
                                        else{
                                            for(int i=0;i<fCounter;i++){
                                                System.out.println("at faculty \""+(i+1)+"\"");
                                                fac[i].print();
                                                System.out.print("__________");
                                            }
                                        }
                                    }
                                    // print employees
                                    case 2->{
                                        if(eCounter==0)
                                            System.out.println("there is no employees yet!");
                                        else{
                                            for(int i=0;i<eCounter;i++){
                                                System.out.println("at employee \""+(i+1)+"\"");
                                                emp[i].print();
                                                System.out.print("__________");
                                            }
                                        }
                                    }
                                    // print students
                                    case 3->{
                                        if(sCounter==0)
                                            System.out.println("there is no students yet!");
                                        else{
                                            for(int i=0;i<sCounter;i++){
                                                System.out.println("at student \""+(i+1)+"\"");
                                                st[i].print();
                                                System.out.print("__________");
                                            }
                                        }
                                    }
                                    default->{
                                        System.out.println("ERROR:invalid input!");
                                    }
                                }
                            }
                            default ->{
                                System.out.println("ERROR:invalid input");
                            }
                        }
                        line();
                        System.out.println("enter \"0\" to get back to the last menue\n"
                            + "\"1\" to search for an entity\n"
                            + "\"2\" to print");
                        choice2=input.nextInt();
                    } //end while loop(output)
                } //end case2 outpud data
                default ->{
                    System.out.println("ERROR:invalid input!");
                }
            } // end big switch
            line();
            System.out.println("enter \"0\" to close program"+
                "\n\"1\" to put data"+
                "\n\"2\" to get data");
            choice =input.nextInt();
        } // end while loop
        System.out.println("Good Luck <3");
    } // end main
    
    //ruler
    public static void line(){
        for (int i=0;i<=20;i++)
            System.out.print("_");
        System.out.println();
    }
    // searching in array of type faculty class
    public static int search(faculty f[],int code){
        if(fCounter==0){
            System.out.println("there is no faculties yet!");
            return -1;
        }
        else{
            int i;
            for(i=0;i<fCounter;i++){
                if(f[i].getCode()==code){
                    return i;
                }
            }
            return -1;
        }
    }
    // check in array of type faculty class
    public static boolean check(faculty f[],int code){
        if(fCounter ==0){
            return false;
        }
        else{
            int i;
        for(i=0;i<fCounter;i++){
            if(f[i].getCode()==code){
                return true;
            }
        }
        return false;
        }
    }
    // searching in array of type student class
    public static int search(student s[],int code){
        int i;
        for(i=0;i<sCounter;i++){
            if(s[i].getcode()==code){
                return i;
            }
        }
        return -1;
    }
    // check in array of type student class
    public static boolean check(student s[],int code){
        if(sCounter==0)
            return false;
        else{
            int i;
            for(i=0;i<sCounter;i++){
                if(s[i].getcode()==code){
                    return true;
                }
            }
            return false;
        }
    }
    // searching in array of type employee class
    public static int search(employee e[],int code){
        int i;
        for(i=0;i<eCounter;i++){
            if(e[i].getCode()==code){
                return i;
            }
        }
        return -1;
    }
    // check in array of type employee class
    public static boolean check(employee e[],int code){
        if(eCounter==0)
            return false;
        else{
            int i;
        for(i=0;i<eCounter;i++){
            if(e[i].getCode()==code){
                return true;
            }
        }
        return false;
        }
    }
}