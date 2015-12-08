package project.notepad;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.NoteViewHolder> {
    private ArrayList<String> notes;
    private Context context;

    public NoteRecyclerViewAdapter(Context context, ArrayList<String> notes) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.saved_message, viewGroup, false);

        return new NoteViewHolder(context, view);
    }


    @Override
    public void onBindViewHolder(final NoteViewHolder noteViewHolder, final int i) {

        noteViewHolder.noteText.setText(notes.get(i));

        noteViewHolder.noteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Heyo clicked");

                Intent intent = new Intent(noteViewHolder.itemView.getContext(), Note.class);
                intent.putExtra("noteText", noteViewHolder.noteText.getText().toString());
                intent.putExtra("id", "" + i);
                noteViewHolder.itemView.getContext().startActivity(intent);
            }
        });

        noteViewHolder.deleteNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("IMAGEBUTTON CLICKED");

                Storage.deleteNote(i);
                notes = Storage.getNotes();
                notifyDataSetChanged();
            }
        });

//        noteViewHolder.hideNotificationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                notificationViewHolder.itemView.setVisibility(View.GONE);
////                int index = notifications.indexOf(i);
//
//                Storage.removeNotification(i);
//                notes = Storage.getNotifications();
////                notifyItemRemoved(index);
//                notifyDataSetChanged();
//            }
//        });

//        if (getItemViewType(i) == 2) {
//
//            noteViewHolder.rescheduleText.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    FullTrip fullTrip = notes.get(i).getFullTrip();
//
//                    if (fullTrip != null) {
//                        Intent intent = new Intent(notificationViewHolder.itemView.getContext(), SearchActivity.class);
//                        intent.putExtra("selectedTrip", fullTrip);
//                        noteViewHolder.itemView.getContext().startActivity(intent);
//                    } else {
//                        Log.d(this.getClass().getCanonicalName(), "FullTrip of notification is null");
//                    }
//                }
//
//            });
//        }
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context mContext;
        CardView cv;
        TextView noteText;
        ImageView deleteNote;

        NoteViewHolder(Context context, View itemView) {
            super(itemView);
            mContext = context;
            cv = (CardView) itemView.findViewById(R.id.card);
            noteText = (TextView) itemView.findViewById(R.id.saved_note);
            deleteNote = (ImageView) itemView.findViewById(R.id.delete);
//            deleteNote.setOnClickListener(this);
            itemView.setOnClickListener(this);
            itemView.setTag(itemView);
        }

        public void onClick(View v) {
//
//            if (v.getId() == R.id.image1) {
//                Intent allNotesIntent = new Intent(mContext, NotificationsActivity.class);
//                allNotesIntent.putExtra(NotificationsActivity.NOTIFICATION_ID_STR, NotificationsActivity.NOTIFICATION_ID);
//                PendingIntent allNotesPendingIntent = PendingIntent.getActivity(mContext, 0, allNotesIntent, PendingIntent.FLAG_CANCEL_CURRENT);
//                NotificationCompat.Builder mBuilder;
//                mBuilder = new NotificationCompat.Builder(mContext);
//                mBuilder.setSmallIcon(R.mipmap.ic_launcher);
//                mBuilder.setContentTitle(mContext.getString(R.string.label_notification_notification));
//                mBuilder.setContentText(notificationText.getText());
//                mBuilder.setAutoCancel(true);
//                mBuilder.setContentText(this.itemView.getResources().getString(R.string.java_notificationsrva_newmessages)).setNumber(++numMessages);
//
//                NotificationManager mNotificationManager = (NotificationManager)
//                        mContext.getSystemService(Context.NOTIFICATION_SERVICE);
//
//                mNotificationManager.notify(NotificationsActivity.NOTIFICATION_ID, mBuilder.build());
//            }
        }
    }

}

