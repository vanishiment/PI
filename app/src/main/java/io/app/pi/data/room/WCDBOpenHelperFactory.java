package io.app.pi.data.room;


import android.arch.persistence.db.SupportSQLiteOpenHelper;

import com.tencent.wcdb.database.SQLiteCipherSpec;

public class WCDBOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    private byte[] mPassphrase;
    private SQLiteCipherSpec mCipherSpec;
    private boolean mWALMode;

    public WCDBOpenHelperFactory passphrase(byte[] value) {
        mPassphrase = value;
        return this;
    }

    public WCDBOpenHelperFactory cipherSpec(SQLiteCipherSpec cipher) {
        mCipherSpec = cipher;
        return this;
    }

    public WCDBOpenHelperFactory writeAheadLoggingEnabled(boolean wal) {
        mWALMode = wal;
        return this;
    }

    @Override
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        WCDBOpenHelper result =  new WCDBOpenHelper(configuration.context, configuration.name,
                mPassphrase, mCipherSpec, configuration.callback);
        result.setWriteAheadLoggingEnabled(mWALMode);
        return result;
    }
}
