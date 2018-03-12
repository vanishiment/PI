package io.app.pi.data.room;


import android.arch.persistence.db.SupportSQLiteStatement;

import com.tencent.wcdb.database.SQLiteStatement;

import java.io.IOException;

class WCDBStatement implements SupportSQLiteStatement {
    private final SQLiteStatement mDelegate;

    /**
     * Creates a wrapper around a framework {@link SQLiteStatement}.
     *
     * @param delegate The SQLiteStatement to delegate calls to.
     */
    public WCDBStatement(SQLiteStatement delegate) {
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
    public void execute() {
        mDelegate.execute();
    }

    @Override
    public int executeUpdateDelete() {
        return mDelegate.executeUpdateDelete();
    }

    @Override
    public long executeInsert() {
        return mDelegate.executeInsert();
    }

    @Override
    public long simpleQueryForLong() {
        return mDelegate.simpleQueryForLong();
    }

    @Override
    public String simpleQueryForString() {
        return mDelegate.simpleQueryForString();
    }

    @Override
    public void close() throws IOException {
        mDelegate.close();
    }
}
