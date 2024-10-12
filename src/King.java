public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) && correctKingMove(line, column, toLine, toColumn);
    }

    private boolean correctKingMove(int line, int column, int toLine, int toColumn){
        return (!(line == toLine && column == toColumn) && (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1));
    }

    //TO DO
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column){
        return false;
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "K";
        else return "k";
    }
}
