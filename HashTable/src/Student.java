/**
 * @author CanYe
 * @createdate 2019/7/17 20:47
 */
public class Student {
    private String name ;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode(){
        int B = 31;
        int hash = 0;
        hash = hash * B + name.hashCode();
        hash = hash * B + age;

        return hash;
    }


    @Override
    public boolean equals(Object o){

        if(this == o){
            return true;
        }

        if(o == null){
            return false;
        }

        if(getClass() != o.getClass()){
            return false;
        }

        Student another = (Student)o;
        return this.name == another.name && this.age == another.age;
    }
}
