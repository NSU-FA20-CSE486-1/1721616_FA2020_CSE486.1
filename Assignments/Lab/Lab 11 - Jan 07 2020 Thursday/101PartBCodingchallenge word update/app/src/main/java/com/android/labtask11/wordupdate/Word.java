
package com.android.labtask11.wordupdate;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(@NonNull String word) {
        this.mWord = word;
    }


    @Ignore
    public Word(int id, @NonNull String word) {
        this.id = id;
        this.mWord = word;
    }

    public String getWord() {
        return this.mWord;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
}
