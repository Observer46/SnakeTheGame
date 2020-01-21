public class Vector2D {
    public final int x;
    public final int y;

    public Vector2D(int x, int y){
        this.x=x;
        this.y=y;
    }

    public Vector2D subtract(Vector2D other){
        return new Vector2D(this.x-other.x,this.y - other.y);
    }
    public Vector2D add(Vector2D other){
        return new Vector2D(this.x+other.x,this.y + other.y);
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public int hashCode(){
        int hash=13;
        hash+=this.x*31;
        hash+=this.y*17;
        return hash;
    }

    @Override
    public boolean  equals(Object other){
        if(this == other)   return true;
        if(!(other instanceof Vector2D))    return false;
        Vector2D that = (Vector2D) other;
        return (this.x==that.x && this.y==that.y) ? true : false;
    }
}
