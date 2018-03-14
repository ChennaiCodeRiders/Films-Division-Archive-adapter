package chennaicoderiders.filmsdivisionarchive;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBHandler extends SQLiteAssetHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "main.db";

    private static final String TABLE_FILM = "film";

    public static final String F_KEY_ID = "id";
    public static final String F_KEY_URL = "url";
    public static final String F_KEY_NAME = "name";
    public static final String F_KEY_DESC = "desc";
    public static final String F_KEY_CATEGORY = "category";
    public static final String F_KEY_LANGUAGE = "language";
    public static final String F_KEY_YEAR = "year";
    public static final String F_KEY_DIRECTOR = "director";
    public static final String F_KEY_IMAGE_URL = "image_url";
    public static final String F_KEY_DURATION = "duration";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public Video getVideo(long id){
        Video video = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FILM + " WHERE " + F_KEY_ID + "=" + id;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            video = new Video(cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4),
                    cursor.getString(5),cursor.getInt(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9));
        }

        return video;

    }

    public Video getMinVideo(long id){
        Video video = null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + F_KEY_NAME + "," + F_KEY_URL + "," + F_KEY_IMAGE_URL + "," + F_KEY_DESC + " FROM " + TABLE_FILM + " WHERE " + F_KEY_ID + "=" + id;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.moveToFirst()) {
            video = new Video(cursor.getString(1),cursor.getString(0), cursor.getString(3),cursor.getString(2));
        }

        return video;
    }

}
