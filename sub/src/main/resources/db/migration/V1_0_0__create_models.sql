CREATE TABLE IF NOT EXISTS "youtubesubscriptiondetails"
(
    "user_id" bigserial,
    "channel_id" bigserial,
    "subscription_at"  timestamp,
    "unsubscription_at" timestamp,
    "subscription_status" boolean,
    "created_at" timestamp default current_timestamp,
    constraint youtube_user_chanel_id primary key ("user_id", "channel_id")
);

CREATE TABLE IF NOT EXISTS "telegramsubscriptiondetails"
(
    "user_id" bigserial,
    "channel_id" bigserial,
    "subscription_at"  timestamp,
    "unsubscription_at" timestamp,
    "subscription_status" boolean,
    "created_at" timestamp default current_timestamp,
    constraint telegram_user_chanel_id primary key ("user_id", "channel_id")
);
