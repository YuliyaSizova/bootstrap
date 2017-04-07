INSERT INTO bootstrap (id, text) VALUES
  (1, 'Manning Publications Co.'),
  (2, 'Packt Publishing Ltd.'),
  (3, 'O’Reilly Media, Inc.'),
  (4, 'Prentice Hall')
ON CONFLICT DO NOTHING;