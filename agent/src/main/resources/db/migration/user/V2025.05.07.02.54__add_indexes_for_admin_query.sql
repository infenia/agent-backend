/*
 *
 * Copyright (c) 2025 Infenia Technologies Pvt. Ltd.
 *
 * This file is part of the EasyMarry Application.
 *
 * Licensed under the Infenia license; you may not use this file except
 * in compliance with the License. Unauthorized copying of this file,
 * via any medium is strictly prohibited.
 *
 * For more information, contact arun@infenia.com
 *
 */

-- Indexes for optimal performance of admin user details query

-- user_account table
CREATE INDEX IF NOT EXISTS idx_user_account_created_at ON iuser.user_account (created_at);
CREATE INDEX IF NOT EXISTS idx_user_account_is_active ON iuser.user_account (is_active);

-- tracker table
CREATE INDEX IF NOT EXISTS idx_tracker_was_online_at ON iuser.tracker (was_online_at);

