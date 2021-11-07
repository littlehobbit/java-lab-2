public enum Mark {
    ONE,
    TWO,
    THREE,
    FOUR;
    
    int mark;
    int usingCount = 0;

    Mark(int mark) {
        this.mark = mark;
    }
}
