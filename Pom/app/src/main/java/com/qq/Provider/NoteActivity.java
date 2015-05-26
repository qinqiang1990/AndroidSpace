package com.qq.Provider;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.qq.Log.Tag;
import com.qq.R;

public class NoteActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter adapter;
    private String TAG = Tag.POEM;
    private String[] PROJECTION = new String[]{
            NotePad._ID,
            NotePad.NOTE_NAME,
            NotePad.NOTE_AGE,
            NotePad.NOTE_ID
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        Intent intent = getIntent();
        if (intent.getData() == null) {
            intent.setData(NotePad.CONTENT_URI);
        }
        Cursor cursor = managedQuery(getIntent().getData(), PROJECTION, null, null, null);


        adapter = new SimpleCursorAdapter(NoteActivity.this, R.layout.noteslist_item, cursor, new String[]{NotePad.NOTE_NAME}, new int[]{android.R.id.text1});
        setListAdapter(adapter);
        getLoaderManager().initLoader(0, null, this);


        Button call = (Button) this.findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Intent.ACTION_INSERT, NoteActivity.this.getIntent().getData());

                NoteActivity.this.startActivity(intent);

            }
        });
    }

    @Override

    protected void onListItemClick(ListView listView, View v, int position, long id) {

        Uri uri = ContentUris.withAppendedId(getIntent().getData(), id);

        startActivity(new Intent(Intent.ACTION_EDIT, uri));

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Log.i(Tag.BAR, "onCreateLoader");
        CursorLoader cursor = new CursorLoader(NoteActivity.this, getIntent().getData(), PROJECTION, null, null, null);
        Log.d(TAG, "MyLoaderListener---------->onCreateLoader");

        return cursor;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        Log.i(TAG, "onLoadFinished");
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        Log.i(TAG, "onLoaderReset");
        adapter.swapCursor(null);
    }
}
