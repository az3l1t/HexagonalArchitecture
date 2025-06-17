CREATE TABLE order_outbox (
    outbox_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    order_type_real_time VARCHAR(255) NOT NULL
)