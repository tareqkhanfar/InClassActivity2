package com.khanfar.inclassacvtivity2;

public class Book {
    private String title ;
    private String author ;
    private int pages ;
    private  boolean avaliable ;

    public Book(String title, String author, int pages , boolean avb ) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.avaliable = avb ;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
