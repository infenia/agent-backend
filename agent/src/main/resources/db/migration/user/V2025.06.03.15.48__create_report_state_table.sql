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

BEGIN;

-- Table: report.report_state

DROP TABLE IF EXISTS report.report_state;

CREATE TABLE IF NOT EXISTS report.report_state
(
    id text COLLATE pg_catalog."default" NOT NULL,
    report_type text COLLATE pg_catalog."default" NOT NULL,
    frequency text COLLATE pg_catalog."default" NOT NULL,
    status text COLLATE pg_catalog."default" NOT NULL,
    last_report_end_time timestamp with time zone,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default",
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,
    CONSTRAINT report_state_pkey PRIMARY KEY (id),
    CONSTRAINT report_state_unique_report_frequency UNIQUE (report_type, frequency)
)

TABLESPACE pg_default;

COMMENT ON TABLE report.report_state
    IS 'Tracks the execution state of report generation for different report types and frequencies.';

COMMENT ON COLUMN report.report_state.id
    IS 'Synthetic primary key composed as reportType:frequency.';

COMMENT ON COLUMN report.report_state.report_type
    IS 'The report type this state corresponds to.';

COMMENT ON COLUMN report.report_state.frequency
    IS 'The frequency of the report (e.g., DAILY, WEEKLY).';

COMMENT ON COLUMN report.report_state.status
    IS 'The current status of report execution (e.g., INITIALIZED, IN_PROGRESS, COMPLETED, FAILED).';

COMMENT ON COLUMN report.report_state.last_report_end_time
    IS 'The end time of the last report execution.';

COMMENT ON COLUMN report.report_state.created_by
    IS 'The user or system who created this state.';

COMMENT ON COLUMN report.report_state.created_at
    IS 'Time at which this record was created.';

COMMENT ON COLUMN report.report_state.updated_by
    IS 'The user or system who last updated this state.';

COMMENT ON COLUMN report.report_state.updated_at
    IS 'Last updated time of the report state.';

COMMENT ON COLUMN report.report_state.version
    IS 'Optimistic locking version field.';

COMMENT ON CONSTRAINT report_state_unique_report_frequency ON report.report_state
    IS 'Ensures that (report_type, frequency) pair is unique.';


COMMIT;
