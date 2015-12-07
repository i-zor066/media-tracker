package com.izor066.android.mediatracker.api.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by igor on 7/11/15.
 */
public class Book implements Parcelable {

    private final String title;
    private final String author;
    private final long datePublished;
    private final String coverImgUri;
    private final String synopsis;
    //ToDo: Add cover image

    public Book(String title, String author, long datePublished, String coverImgUri, String synopsis) {
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.coverImgUri = coverImgUri;
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", datePublished=" + datePublished +
                ", coverImgUri='" + coverImgUri + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getDatePublished() {
        return datePublished;
    }

    public String getCoverImgUri() {
        return coverImgUri;
    }

    public String getSynopsis() {
        return synopsis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();

        bundle.putString("title", title);
        bundle.putString("author", author);
        bundle.putLong("datePublished", datePublished);
        bundle.putString("coverImgUri", coverImgUri);
        bundle.putString("synopsis", synopsis);

        dest.writeBundle(bundle);

    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        public Book createFromParcel(Parcel source){
            Bundle bundle = source.readBundle();

            return new Book(
                    bundle.getString("title"),
                    bundle.getString("author"),
                    bundle.getLong("datePublished"),
                    bundle.getString("coverImgUri"),
                    bundle.getString("synopsis"));
        }

        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
