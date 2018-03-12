package io.app.pi.data.room;


import android.arch.persistence.db.SupportSQLiteProgram;

import com.tencent.wcdb.database.SQLiteProgram;

import java.io.IOException;

class WCDBProgram implements SupportSQLiteProgram {
    private final SQLiteProgram mDelegate;

    WCDBProgram(SQLiteProgram delegate) {
        mDelegate = delegate;
    }

    @Override
    public void bindNull(int index) {
        mDelegate.bindNull(index);
    }

    @Override
    public void bindLong(int index, long value) {
        mDelegate.bindLong(index, value);
    }

    @Override
    public void bindDouble(int index, double value) {
        mDelegate.bindDouble(index, value);
    }

    @Override
    public void bindString(int index, String value) {
        mDelegate.bindString(index, value);
    }

    @Override
    public void bindBlob(int index, byte[] value) {
        mDelegate.bindBlob(index, value);
    }

    @Override
    public void clearBindings() {
        mDelegate.clearBindings();
    }

    @Override
    public void close() throws IOException {
        mDelegate.close();
    }
}
