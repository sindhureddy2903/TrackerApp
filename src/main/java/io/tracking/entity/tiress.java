package io.tracking.entity;

 import javax.persistence.*;
 import java.sql.Timestamp;
        import java.util.Arrays;
        import java.util.Map;
        import java.util.UUID;


@Entity
public class tiress {
    @Id
    private String id;
    public tiress(){
        this.id = UUID.randomUUID()
                .toString();
    }

   private int frontLeft;
    private int  frontRight;
    private int rearLeft;
    private int rearRight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "tiress{" +
                "id='" + id + '\'' +
                ", frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}


