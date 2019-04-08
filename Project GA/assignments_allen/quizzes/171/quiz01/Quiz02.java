public class Quiz02
{
  public static void main( String[] args )
    {
    	DrawingGizmo pen;
    	pen = new DrawingGizmo();
    	DrawingGizmo pencil = new DrawingGizmo();
    	
    	DrawingGizmo draw1, draw2, draw3;
    	draw1 = pen;
    	draw2 = pencil;
    	pen = null;
    }
}
