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
        return movesInBoundaries(toLine, toColumn) &&
                correctKingMove(line, column, toLine, toColumn) &&
                isMovingWithoutCollision(chessBoard, line, column, toLine, toColumn);
    }

    private boolean correctKingMove(int line, int column, int toLine, int toColumn){
        return (!(line == toLine && column == toColumn) && (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1));
    }

    //TO DO
    public boolean isUnderAttack(ChessBoard chessBoard, String color, int line, int column){
        return isUnderAttackByPawn(chessBoard, color, line, column);
    }

    private boolean isUnderAttackByPawn(ChessBoard chessBoard, String color, int line, int column){
        for (int i = line - 1; i <= line + 1; i += 2){
            for (int j = column - 1; j <= column + 1; j += 2){
                if(chessBoard.checkPos(i) && chessBoard.checkPos(j)){
                    if(chessBoard.board[i][j] != null) {
                        if (!color.equals(chessBoard.board[i][j].getColor())) return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null) return true;
        else {
            return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
        }
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "K";
        else return "k";
    }
}
