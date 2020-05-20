package pojo;

import lombok.Data;

/**
 * Created by luwb on 2020/05/20.
 */
@Data
public abstract class Shape implements Cloneable{

    private String id;

    protected String type;

    abstract void draw();

    @Override
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
