CREATE TABLE oneclickpurchase
(
  uid      BIGINT      NOT NULL,
  name     VARCHAR(50) NOT NULL,
  phone	   VARCHAR(10) NOT NULL,    
  email    VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX oneclickpurchase_uid_uindex ON oneclickpurchase (uid);
ALTER TABLE oneclickpurchase
  ADD CONSTRAINT oneclickpurchase_uid_pk PRIMARY KEY (uid);
CREATE SEQUENCE oneclickpurchase_uid_seq NO MINVALUE NO MAXVALUE NO CYCLE;
ALTER TABLE oneclickpurchase
  ALTER COLUMN uid SET DEFAULT nextval('oneclickpurchase_uid_seq');
ALTER SEQUENCE oneclickpurchase_uid_seq OWNED BY oneclickpurchase.uid;