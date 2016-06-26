package org.literacyapp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import org.literacyapp.dao.converter.LocaleConverter;
import org.literacyapp.model.enums.Locale;

import org.literacyapp.dao.Letter;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LETTER".
*/
public class LetterDao extends AbstractDao<Letter, Long> {

    public static final String TABLENAME = "LETTER";

    /**
     * Properties of entity Letter.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Locale = new Property(1, String.class, "locale", false, "LOCALE");
        public final static Property Text = new Property(2, String.class, "text", false, "TEXT");
    };

    private final LocaleConverter localeConverter = new LocaleConverter();

    public LetterDao(DaoConfig config) {
        super(config);
    }
    
    public LetterDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LETTER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"LOCALE\" TEXT," + // 1: locale
                "\"TEXT\" TEXT);"); // 2: text
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LETTER\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Letter entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Locale locale = entity.getLocale();
        if (locale != null) {
            stmt.bindString(2, localeConverter.convertToDatabaseValue(locale));
        }
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(3, text);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Letter readEntity(Cursor cursor, int offset) {
        Letter entity = new Letter( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : localeConverter.convertToEntityProperty(cursor.getString(offset + 1)), // locale
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // text
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Letter entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setLocale(cursor.isNull(offset + 1) ? null : localeConverter.convertToEntityProperty(cursor.getString(offset + 1)));
        entity.setText(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Letter entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Letter entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
