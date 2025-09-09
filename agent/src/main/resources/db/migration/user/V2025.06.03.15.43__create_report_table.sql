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

-- Table: report.report

DROP TABLE IF EXISTS report.report;

CREATE TABLE IF NOT EXISTS report.report
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    report_type text COLLATE pg_catalog."default" NOT NULL,
    frequency text COLLATE pg_catalog."default" NOT NULL,
    status text COLLATE pg_catalog."default" NOT NULL,
    result_json text COLLATE pg_catalog."default",
    error_message text COLLATE pg_catalog."default",
    report_start_time timestamp with time zone,
    report_end_time timestamp with time zone,
    created_by text COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by text COLLATE pg_catalog."default" NOT NULL,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    version bigint NOT NULL,

    CONSTRAINT report_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

COMMENT ON TABLE report.report
    IS 'Tracks the generation, execution status, and results of reports.';

COMMENT ON COLUMN report.report.id
    IS 'Unique identifier for the report record.';

COMMENT ON COLUMN report.report.report_type
    IS 'The type/category of the report (e.g., USER_SIGNUPS, PAYMENTS).';

COMMENT ON COLUMN report.report.frequency
    IS 'The frequency of report execution (e.g., DAILY, WEEKLY).';

COMMENT ON COLUMN report.report.status
    IS 'Current execution status of the report (e.g., INITIALIZED, IN_PROGRESS, COMPLETED, FAILED).';

COMMENT ON COLUMN report.report.result_json
    IS 'The result of the report stored in JSON format.';

COMMENT ON COLUMN report.report.error_message
    IS 'Any error message that occurred during report generation.';

COMMENT ON COLUMN report.report.report_start_time
    IS 'Start time of the data window considered for this report.';

COMMENT ON COLUMN report.report.report_end_time
    IS 'End time of the data window considered for this report.';

COMMENT ON COLUMN report.report.created_by
    IS 'User or system that initiated this report.';

COMMENT ON COLUMN report.report.created_at
    IS 'Timestamp when the report was created.';

COMMENT ON COLUMN report.report.updated_by
    IS 'User or system who last updated this report.';

COMMENT ON COLUMN report.report.updated_at
    IS 'Timestamp when the report was last updated.';

COMMENT ON COLUMN report.report.version
    IS 'Optimistic locking version field.';

CREATE INDEX idx_completed_report_type_freq_endtime
ON report.report (report_type, frequency, report_end_time)
WHERE status = 'COMPLETED';

COMMIT;
