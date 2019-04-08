public class Quiz01
{
  public static void main( String[] args )
    {
    	DrawingGizmo pen = new DrawingGizmo();
    	DrawingGizmo pencil = new DrawingGizmo();
    	
    	DrawingGizmo gizmo1, gizmo2, gizmo3;
    	gizmo1 = pencil;
    	pencil = pen;
    	gizmo2 = pen;
    	pen = null;
    }
}
