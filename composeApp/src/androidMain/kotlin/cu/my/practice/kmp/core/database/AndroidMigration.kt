package cu.my.practice.kmp.core.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//SupportSQLiteDatabase -> Just alive in android

//Reemplaza your_table_name y new_column_name por el nombre de la tabla y la columna específica de tu base de datos.
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // Escribe aquí las instrucciones para actualizar la base de datos
        database.execSQL("ALTER TABLE your_table_name ADD COLUMN new_column_name INTEGER NOT NULL DEFAULT 0")
    }
}
/*
//Project
    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL(
                "CREATE TABLE travels_table (\n" +
                        " id INTEGER PRIMARY KEY NOT NULL DEFAULT 0,\n" +
                        " country TEXT NOT NULL DEFAULT '',\n" +
                        " go_date TEXT NOT NULL DEFAULT '',\n" +
                        " back_date TEXT NOT NULL DEFAULT '',\n" +
                        " date TEXT NOT NULL DEFAULT ''\n" +
                        ");\n"
            )
        }
    }

    val MIGRATION_3_4 = object : Migration(3, 4) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE products_table ADD COLUMN travel_id INTEGER NOT NULL DEFAULT 0")
        }
    }

    val MIGRATION_4_5 = object : Migration(4, 5) {
        override fun migrate(db: SupportSQLiteDatabase) {
            db.execSQL("ALTER TABLE category_table ADD COLUMN icon TEXT NULL DEFAULT NULL")
        }
    }

    val MIGRATION_5_6 = object : Migration(5, 6) {
        override fun migrate(db: SupportSQLiteDatabase) {
            // Products
            db.execSQL("ALTER TABLE products_table ADD COLUMN created_at TEXT NULL DEFAULT NULL")
            db.execSQL("ALTER TABLE products_table ADD COLUMN updated_at TEXT NULL DEFAULT NULL")
            db.execSQL("ALTER TABLE products_table ADD COLUMN delete_at TEXT NULL DEFAULT NULL")
            // Categories
            db.execSQL("ALTER TABLE category_table ADD COLUMN created_at TEXT NULL DEFAULT NULL")
            db.execSQL("ALTER TABLE category_table ADD COLUMN updated_at TEXT NULL DEFAULT NULL")
            db.execSQL("ALTER TABLE category_table ADD COLUMN delete_at TEXT NULL DEFAULT NULL")
            // Travels
            db.execSQL("ALTER TABLE travels_table ADD COLUMN created_at TEXT NULL DEFAULT NULL")
            db.execSQL("ALTER TABLE travels_table ADD COLUMN updated_at TEXT NULL DEFAULT NULL")
            db.execSQL("ALTER TABLE travels_table ADD COLUMN delete_at TEXT NULL DEFAULT NULL")
        }
    }
*/
