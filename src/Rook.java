public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return movesInBoundaries(toLine, toColumn) &&
                correctRookMove(line, column, toLine, toColumn) &&
                isMovingWithoutCollision(chessBoard, line, column, toLine, toColumn);
    }

    private boolean correctRookMove(int line, int column, int toLine, int toColumn) {
        return ((column == toColumn && line != toLine) || (column != toColumn && line == toLine));
    }

    @Override
    public boolean isMovingWithoutCollision(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int currentLine;
        int currentColumn;
        if (toLine > line && toColumn == column) {
            currentLine = line + 1;
            currentColumn = column;
            while (currentLine < toLine) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentLine++;
            }
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else {
                return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
            }
        } else if (toLine == line && toColumn > column) {
            currentLine = line;
            currentColumn = column + 1;
            while (currentColumn < toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentColumn++;
            }
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else {
                return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
            }
        } else if (toLine < line && toColumn == column) {
            currentLine = line - 1;
            currentColumn = column;
            while (currentLine > toLine) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
                currentLine--;
            }
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else {
                return !chessBoard.board[toLine][toColumn].getColor().equals(chessBoard.board[line][column].getColor());
            }
        } else if (toLine == line && toColumn < column) {
            currentLine = line;
            currentColumn = column - 1;
            while (currentColumn > toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) return false;
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
        if (color.equals("White")) return "R";
        else return "r";
    }
}
