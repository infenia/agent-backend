-- Indexes for optimal performance of admin user details query

-- user_account table
CREATE INDEX IF NOT EXISTS idx_user_account_created_at ON iuser.user_account (created_at);
CREATE INDEX IF NOT EXISTS idx_user_account_is_active ON iuser.user_account (is_active);

-- tracker table
CREATE INDEX IF NOT EXISTS idx_tracker_was_online_at ON iuser.tracker (was_online_at);

