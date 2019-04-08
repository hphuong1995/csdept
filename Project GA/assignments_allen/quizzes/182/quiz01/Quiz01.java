public class Quiz01
{
  public static void main( String[] args )
    {
    	DrawingGizmo pen = new DrawingGizmo();
    	DrawingGizmo pencil = new DrawingGizmo();
    	
    	DrawingGizmo gizmo1, gizmo2, gizmo3;
    	gizmo1 = pen;
    	pen = pencil;
    	gizmo2 = pencil;
    	pencil = null;
    }
}
