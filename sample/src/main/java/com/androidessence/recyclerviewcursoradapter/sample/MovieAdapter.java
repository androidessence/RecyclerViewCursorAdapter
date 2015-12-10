package com.androidessence.recyclerviewcursoradapter.sample;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidessence.recyclerviewcursoradapter.RecyclerViewCursorAdapter;
import com.androidessence.recyclerviewcursoradapter.RecyclerViewCursorViewHolder;
import com.androidessence.recyclerviewcursoradapter.sample.data.MovieContract;

/**
 * Demonstrates the use of a RecyclerViewCursorAdapter to display a list of movies.
 *
 * Created by adammcneilly on 12/8/15.
 */
public class MovieAdapter extends RecyclerViewCursorAdapter<MovieAdapter.MovieViewHolder>{

    /**
     * Column projection for the query to pull Movies from the database.
     */
    public static final String[] MOVIE_COLUMNS = new String[] {
            MovieContract.MovieEntry.TABLE_NAME + "." + MovieContract.MovieEntry._ID,
            MovieContract.MovieEntry.COLUMN_NAME
    };

    /**
     * Index of the name column.
     */
    private static final int NAME_INDEX = 1;

    /**
     * Constructor.
     * @param context The Context the Adapter is displayed in.
     */
    public MovieAdapter(Context context) {
        super(context);

        setupCursorAdapter(null, 0, R.layout.list_item_movie, false);
    }

    /**
     * Returns the ViewHolder to use for this adapter.
     */
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(mCursorAdapter.newView(mContext, mCursorAdapter.getCursor(), parent));
    }

    /**
     * Moves the Cursor of the CursorAdapter to the appropriate position and binds the view for
     * that item.
     */
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        // Move cursor to this position
        mCursorAdapter.getCursor().moveToPosition(position);

        // Set the ViewHolder
        setViewHolder(holder);

        // Bind this view
        mCursorAdapter.bindView(null, mContext, mCursorAdapter.getCursor());
    }

    /**
     * ViewHolder used to display a movie name.
     */
    public class MovieViewHolder extends RecyclerViewCursorViewHolder {
        public final TextView mMovieName;

        public MovieViewHolder(View view) {
            super(view);

            mMovieName = (TextView) view.findViewById(R.id.movie_name);
        }

        @Override
        public void bindCursor(Cursor cursor) {
            mMovieName.setText(cursor.getString(NAME_INDEX));
        }
    }
}
