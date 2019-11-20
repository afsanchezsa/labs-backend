


DROP TABLE IF EXISTS "labs"."public"."grade";
DROP TABLE IF EXISTS "labs"."public"."association";
DROP TABLE IF EXISTS "labs"."public"."payment_method";
DROP TABLE IF EXISTS "labs"."public"."state";
DROP TABLE IF EXISTS "labs"."public"."balance";
DROP TABLE IF EXISTS "labs"."public"."course";
DROP TABLE IF EXISTS "labs"."public"."user_role";
DROP TABLE IF EXISTS "labs"."public"."user";
DROP TABLE IF EXISTS "labs"."public"."role";
DROP TABLE IF EXISTS "labs"."public"."period";


-- ---------------------------- --
-- Table "labs"."public"."user" --
-- ---------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."user"
(
    "user_id"  SERIAL       NOT NULL,
    "username" VARCHAR(10)  NOT NULL,
    "password" VARCHAR(256) NOT NULL,
    "names"    VARCHAR(100) NOT NULL,
    "surnames" VARCHAR(100) NOT NULL,
    PRIMARY KEY ("user_id")
);


-- ------------------------------ --
-- Table "labs"."public"."course" --
-- ------------------------------ --
CREATE TABLE IF NOT EXISTS "labs"."public"."course"
(
    "course_id"      SERIAL       NOT NULL,
    "course_name"    VARCHAR(100) NOT NULL,
    "duration_hours" INT          NOT NULL,
    "cost" INT NOT NULL,
    PRIMARY KEY ("course_id")
);


-- ---------------------------- --
-- Table "labs"."public"."role" --
-- ---------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."role"
(
    "role_id"   INTEGER     NOT NULL,
    "role_name" VARCHAR(20) NOT NULL,
    PRIMARY KEY ("role_id")
);


-- --------------------------------- --
-- Table "labs"."public"."user_role" --
-- --------------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."user_role"
(
    "user_id" INT NOT NULL,
    "role_id" INT NOT NULL,
    PRIMARY KEY ("user_id", "role_id"),
    CONSTRAINT "fk_user_id"
        FOREIGN KEY ("user_id")
            REFERENCES "labs"."public"."user" ("user_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_role_id"
        FOREIGN KEY ("role_id")
            REFERENCES "labs"."public"."role" ("role_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE INDEX "idx_user_role_user_id" ON "labs"."public"."user" ("user_id" ASC);
CREATE INDEX "idx_user_role_role_id" ON "labs"."public"."role" ("role_id" ASC);


-- ------------------------------ --
-- Table "labs"."public"."period" --
-- ------------------------------ --
CREATE TABLE IF NOT EXISTS "labs"."public"."period"
(
    "period_id"   SERIAL      NOT NULL,
    "period_name" VARCHAR(20) NOT NULL,
    PRIMARY KEY ("period_id")
);
-- ----------------------------------- --
-- Table "labs"."public"."payment_method" --
-- ----------------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."payment_method"
(
    "payment_method_id" SERIAL NOT NULL,
    "name"        VARCHAR(30)    NOT NULL,
    PRIMARY KEY ("payment_method_id")
    );
    -- ----------------------------------- --
-- Table "labs"."public"."state" --
-- ----------------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."state"
(
    "state_id" SERIAL NOT NULL,
    "name"        VARCHAR(20)    NOT NULL,

    PRIMARY KEY ("state_id")

);
-- ----------------------------------- --
-- Table "labs"."public"."balance" --
-- ----------------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."balance"
(
    "balance_id" SERIAL NOT NULL,
    "balance_payed"        INT    NOT NULL,
    "total_cost"        INT    NOT NULL,
    PRIMARY KEY("balance_id")

);
-- ----------------------------------- --
-- Table "labs"."public"."association" --
-- ----------------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."association"
(
    "association_id" SERIAL NOT NULL,
    "user_id"        INT    NOT NULL,
    "role_id"        INT    NOT NULL,
    "course_id"      INT    NOT NULL,
    "period_id"      INT    NOT NULL,
    "payment_method_id" INT NOT NULL,
    "state_id" INT NOT NULL,
    "balance_id" INT NOT NULL,
    PRIMARY KEY ("association_id"),
    CONSTRAINT "fk_user_role"
        FOREIGN KEY ("user_id", "role_id")
            REFERENCES "labs"."public"."user_role" ("user_id", "role_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_course"
        FOREIGN KEY ("course_id")
            REFERENCES "labs"."public"."course" ("course_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_period"
        FOREIGN KEY ("period_id")
            REFERENCES "labs"."public"."period" ("period_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_payment_method"
        FOREIGN KEY ("payment_method_id")
            REFERENCES "labs"."public"."payment_method" ("payment_method_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_state"
        FOREIGN KEY ("state_id")
            REFERENCES "labs"."public"."state" ("state_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT "fk_balance"
        FOREIGN KEY ("balance_id")
            REFERENCES "labs"."public"."balance" ("balance_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE INDEX "idx_association_user_role_id" ON "labs"."public"."association" ("user_id" ASC, "role_id" ASC);
CREATE INDEX "idx_association_course_id" ON "labs"."public"."association" ("course_id" ASC);
CREATE INDEX "idx_association_period_id" ON "labs"."public"."association" ("period_id" ASC);


-- ----------------------------- --
-- Table "labs"."public"."grade" --
-- ----------------------------- --
CREATE TABLE IF NOT EXISTS "labs"."public"."grade"
(
    "grade_id"       SERIAL  NOT NULL,
    "approved"       BOOLEAN NULL,
    "note"           REAL    NULL,
    "association_id" INT     NOT NULL,
    PRIMARY KEY ("grade_id"),
    CONSTRAINT "fk_association"
        FOREIGN KEY ("association_id")
            REFERENCES "labs"."public"."association" ("association_id")
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);
CREATE UNIQUE INDEX "unq_grade_association" ON "labs"."public"."grade" ("association_id");
CREATE INDEX "idx_grade_association_id" ON "labs"."public"."grade" ("association_id" ASC);


-- ------------------------------------------------------------------------------------------------------------------ --
--                                                   INSERTION DATA                                                   --
-- ------------------------------------------------------------------------------------------------------------------ --

-- --------- --
-- Role data --
-- --------- --

INSERT INTO "labs"."public"."role" (role_id, role_name)
    VALUES (1, 'Estudiante'),
           (2, 'Profesor');

-- ----------- --
-- Period data --
-- ----------- --

INSERT INTO "labs"."public"."period" (period_name)
    VALUES ('Periodo 2019-02');


INSERT INTO "labs"."public"."user"("username","password","names","surnames")
    VALUES('afsanchez','1234','Andres Felipe','Sanchez Sanchez');
INSERT INTO "labs"."public"."user_role"
VALUES(1,1)
;
INSERT INTO "labs"."public"."user"("username","password","names","surnames")
    VALUES('est','1234','Estudiante','1');
INSERT INTO "labs"."public"."user_role"
VALUES(2,2)
;
INSERT INTO "labs"."public"."course"("course_name","duration_hours","cost")
VALUES('ALGEBRA',100,1000);
INSERT INTO "labs"."public"."payment_method"("name")VALUES('cashpayment');
INSERT INTO "labs"."public"."payment_method"("name")VALUES('installmentpayment');
INSERT INTO "labs"."public"."state"("name")VALUES('paidout');
INSERT INTO "labs"."public"."state"("name")VALUES('partialpayment');
INSERT INTO "labs"."public"."state"("name")VALUES('outstanding');
INSERT INTO "labs"."public"."balance"("balance_payed","total_cost") VALUES(0,1000);
INSERT INTO "labs"."public"."association"("user_id","role_id","course_id","period_id","payment_method_id","state_id","balance_id")
VALUES (2,2,1,1,2,3,1);


--INSERT INTO "labs"."public"."association"("user_id","role_id","course_id","period_id","payment_method_id")
--VALUES (2,2,1,1);

