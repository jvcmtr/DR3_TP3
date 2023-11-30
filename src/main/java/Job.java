public class Job {
    private float number;
    public Job(float i){
        number = i;
    }

    public boolean succeed(){
        return (number>0.2);
    };

    public float getNumber(){
        return number;
    }
}
