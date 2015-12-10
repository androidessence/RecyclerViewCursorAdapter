package com.androidessence.recyclerviewcursoradapter.sample;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.androidessence.recyclerviewcursoradapter.sample.data.MovieContract;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    private MovieAdapter mMovieAdapter;

    private static final int MOVIE_LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup RecyclerView
        RecyclerView mMovieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMovieRecyclerView.setLayoutManager(linearLayoutManager);

        mMovieAdapter = new MovieAdapter(this);
        mMovieRecyclerView.setAdapter(mMovieAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Initialize Movie Loader
        getSupportLoaderManager().initLoader(MOVIE_LOADER, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch(id) {
            case MOVIE_LOADER:
                return new CursorLoader(
                        this,
                        MovieContract.MovieEntry.CONTENT_URI,
                        MovieAdapter.MOVIE_COLUMNS,
                        null,
                        null,
                        null
                );
            default:
                throw new UnsupportedOperationException("Unknown loader id: " + id);
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        switch(loader.getId()) {
            case MOVIE_LOADER:
                mMovieAdapter.swapCursor(data);
                break;
            default:
                throw new UnsupportedOperationException("Unknown loader id: " + loader.getId());
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        switch(loader.getId()) {
            case MOVIE_LOADER:
                mMovieAdapter.swapCursor(null);
                break;
            default:
                throw new UnsupportedOperationException("Unknown loader id: " + loader.getId());
        }
    }
}
