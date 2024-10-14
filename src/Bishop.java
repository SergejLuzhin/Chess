public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) &&
                correctBishopMove(line, column, toLine, toColumn) &&
                isMovingWithoutCollision(chessBoard, line, column, toLine, toColumn);
    }

    private boolean correctBishopMove(int line, int column, int toLine, int toColumn) {
        return ((Math.abs(line - toLine) == Math.abs(column - toColumn)) && !(line == toLine || column == toColumn));
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int currentLine;
        int currentColumn;
        if (toLine > line && toColumn > column) {
            currentLine = line + 1;
            currentColumn = column + 1;
            while (currentLine < toLine && currentColumn < toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentLine++;
                currentColumn++;
            }
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else {
                return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
            }
        } else if (toLine < line && toColumn > column) {
            currentLine = line - 1;
            currentColumn = column + 1;
            while (currentLine > toLine && currentColumn < toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentLine--;
                currentColumn++;
            }
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else {
                return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
            }
        } else if (toLine < line && toColumn < column) {
            currentLine = line - 1;
            currentColumn = column - 1;
            while (currentLine > toLine && currentColumn > toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentLine--;
                currentColumn--;
            }
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else {
                return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
            }
        } else if (toLine > line && toColumn < column) {
            currentLine = line + 1;
            currentColumn = column - 1;
            while (currentLine < toLine && currentColumn > toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentLine++;
                currentColumn--;
            }
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else {
                return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        if (color.equals("White")) return "B";
        else return "b";
    }
}
