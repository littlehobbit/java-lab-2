public class User implements Comparable<User> {
    private int id;
    private int reviewsCount = 0;
    private int badReviewsCount = 0;

    public User(int id) {
        this.id = id;
    }

    public void incReviewsCount() {
        reviewsCount++;
    }

    public void incBadReviewsCount() {
        badReviewsCount++;
    }

    public int getReviewsCount() {
        return reviewsCount;
    }

    public int getBadReviewsCount() {
        return badReviewsCount;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        } else {
            User rhs = (User)obj;
            return this.id == rhs.id;
        }
    }

    @Override
    public int compareTo(User rhs) {
            return Integer.compare(this.id, rhs.id);
    }
}
