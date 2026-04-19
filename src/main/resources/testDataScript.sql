-- USERS (4 brugere)
-- Passwords: Test1234, Demo5678, Julemand22, Fest2024
INSERT INTO users (name, email, password)
VALUES ('Ole Hansen', 'ole@example.com', '$2a$10$kYPvhiQL3r1Qiq3gfkJXpeNAv4PTZWniyvSNsGeLAMgkm7v86MhiS'),
       ('Anna Jensen', 'anna@example.com', '$2a$10$Bhf2lXF703d44tOD14Al4eQKgcbn.wAbD.eyxkZFPTGTx3FJJj.fy'),
       ('Per Larsen', 'per@example.com', '$2a$10$/XDfj6ZHpaXklHjmxgYGo.hsbHqC8Rv0JyjSoK3bRD.14sR7C3iim'),
       ('Sofie Andersen', 'sofie@example.com', '$2a$10$umclHnOovtbHwmvoNFjkpOobzFw0DsvOEeT2h1kZz3tp3hotqRdcm');

-- WISHLISTS
-- Ole: 2 wishlists (Fødselsdag, Jul)
INSERT INTO wishlist (name, user_id)
VALUES ('Fødselsdag 2024', 1),
       ('Jul 2024', 1);

-- Anna: 3 wishlists (Fødselsdag, Bryllup, Hjem)
INSERT INTO wishlist (name, user_id)
VALUES ('Fødselsdag 2025', 2),
       ('Bryllup - Gaver', 2),
       ('Hjemmet - Ønskeliste', 2);

-- Per: 1 wishlist (Julegaver)
INSERT INTO wishlist (name, user_id)
VALUES ('Julegaver 2024', 3);

-- Sofie: 2 wishlists (Konfirmation, Ferie)
INSERT INTO wishlist (name, user_id)
VALUES ('Konfirmation 2024', 4),
       ('Ferie-gadgets', 4);

-- WISHES
-- Ole - Fødselsdag (id=1)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Fodbold', 'Professionel fodbold til træning', 199.00,
        'https://www.bilka.dk/produkter/adidas-fodbold-str-5-vm-2026/200348500/', 1),
       ('Gaming headset', 'Trådløst headset til gaming', 449.00,
        'https://www.elgiganten.dk/product/gaming/spiltilbehor/gaming-headset/hyperx-cloud-iii-gaming-headset-sortrod/624212?utm_source=google&utm_medium=cpc&utm_campaign=DK%20-%20LIA%20-%20AO%20-%20CE%20-%20Branded&utm_id=23200326921&gad_source=1&gad_campaignid=23200326921&gbraid=0AAAAAD-SSGBl_-GqniMme1kQ9GsACw-Ur',
        1),
       ('Bogen "Atomic Habits"', 'Populær bog om vaner og selvforbedring', 199.95, NULL, 1),
       ('Fitness tracker', 'Smartwatch til træning og sundhed', 1699.00,
        'https://www.elgiganten.dk/product/mobil-tablet-smartwatch/smartwatch/huawei-watch-gt6-46mm-smartwatch-sort/966486?qid=8588ad7477770bd6afcc1b3ae8638657',
        1);

-- Ole - Jul (id=2)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Julesweater', 'Hyggelig julesweater i rød', 600.00,
        'https://freya-copenhagen.com/products/agnes-stilfuld-og-behagelig-vinterjulesweater-med-rensdyr?currency=DKK&variant=56116950270327&stkn=af5889b6c3aa&gad_source=1&gad_campaignid=23511844469&gbraid=0AAAABCvT1C0538gwz7MP8vorWk-cnmz61',
        2),
       ('Chokolade assortment', 'Luksus chokolader fra Lindt', 149.99, NULL, 2),
       ('USB-C kabel (3 stk)', 'Hurtig opladning, 3 meter', 199.99, NULL, 2),
       ('Bluetooth højtaler', 'Bærbar højtaler med god lyd', 349.00,
        'https://www.elgiganten.dk/product/tv-lyd-smart-home/hojtalere-hi-fi/hojttalere/jbl-clip-5-barbar-hojttaler-sort/757499?utm_source=google&utm_medium=cpc&utm_campaign=DK%20-%20LIA%20-%20AO%20-%20CE%20-%20Branded&utm_id=23200326921&gad_source=1&gad_campaignid=23200326921&gbraid=0AAAAAD-SSGBl_-GqniMme1kQ9GsACw-Ur',
        2),
       ('Termokande', 'Isoleringskande til kaffe/te', 799.00,
        'https://www.elgiganten.dk/product/hjem-rengoring-kokkenudstyr/kokkenredskaber/termokander/coffee-queen-termokande/CQ1103184?qid=c39700c6e087f4dbe77de8ef59d23bd3',
        2);

-- Anna - Fødselsdag (id=3)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Yoga mat', 'Miljøvenlig yoga måtte', 249.00,
        'https://fitnessshoppen.dk/shop/tunturi-8mm-yogamaatte-68209p.html?gad_source=1&gad_campaignid=21427256852&gbraid=0AAAAAClpd4JpHj3lLhm6fbCyJq02JXKKf',
        3),
       ('Parfume', 'Chanel No. 5 - 50ml', 799.00, NULL, 3),
       ('Bogen "Veganisme101"', 'Guide til plantebaseret liv', 159.95, NULL, 3);

-- Anna - Bryllup (id=4)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Champagneglas (6 stk)', 'Elegante champagneglas', 899.00,
        'https://www.magasin.dk/champagneglas-quatrophil-290ml--6-stk/S13355561.html?gad_source=1&gad_campaignid=9790769002',
        4),
       ('Luksus duvet', '100% egyptisk bomuld, høj thread count', 1560.00,
        'https://www.damask.dk/products/original-stripe-dynebetraek-white?variant=50101296759093&sdag=EAIaIQobChMIr9rJ_q7vkwMVqVCRBR12rC14EAQYAiABEgJ0dfD_BwE&gad_source=1&gad_campaignid=21867414452&gbraid=0AAAAADyMUxbKWoXyA9lUeUQJmITllOdyB',
        4),
       ('Kaffemaskine', 'Espresso maskine til hjemmet', 2999.00,
        'https://www.elgiganten.dk/product/outlet/delonghi-magnifica-evo-ecam29061sb-automatisk-espressomaskine/414584?utm_source=google&utm_medium=cpc&utm_campaign=DK%20-%20Shopping%20-%20AO%20-%20Outlet%20-%20Branded&utm_id=23051371915&gad_source=1&gad_campaignid=23051371915&gbraid=0AAAAAD-SSGD1UlgrQAkE5FYtQIWUOnPEx',
        4),
       ('Kunstudskrift', 'Modern art print til stuen', 499.00, NULL, 4);

-- Anna - Hjemmet (id=5)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Blender', 'Kraftig blender til smoothies', 799.00,
        'https://www.elgiganten.dk/product/hjem-rengoring-kokkenudstyr/kokkenudstyr/miksere-blendere/blender/philips-5000-series-blender-hr304100-sort/774653?qid=bf3bdda68671545bda5a7c24d12684f2',
        5),
       ('LED striplight', 'Farveskiftende LED-lys', 298.00,
        'https://www.thomann.dk/botex_led_stripe_rgbww_5m.htm?glp=1&gad_source=1&gad_campaignid=1560178938&gbraid=0AAAAADuDMCXOBKxkkWTN55CoAebqXhJrS',
        5),
       ('Planteropholder', 'Moderne plantekrukker (sæt á 3)', 799.00, NULL, 5);

-- Per - Julegaver (id=6)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Cykelhjælm', 'Sikkerhedshjælm til cykling', 399.00,
        'https://cykelexperten.dk/Specialized-Align-II-Mips-cykelhjelm-2020-Sort-608211042/?gad_source=1&gad_campaignid=22936469478&gbraid=0AAAAADyJ1ErHjsBb1PbPIqaecwgLMr-OG',
        6),
       ('Elektrisk barbermaskine', 'Philips barbermaskine', 3225.00,
        'https://www.avxperten.dk/philips-i9000-prestige-vad-tor-elektrisk-barbermaskine-triple-lift.asp?ss_gc=EAIaIQobChMI2JrexK_vkwMVihCiAx0s6AzqEAQYBCABEgL5Y_D_BwE&gad_source=1&gad_campaignid=1616069237&gbraid=0AAAAAD87SX7qvR_qdczDJwm2R9355XQe5',
        6),
       ('Golf-sættet', 'Beginner golf kit med 14 køller', 2499.99, NULL, 6),
       ('Bog - "Serverside programmering"', 'Teknisk bog om backend udvikling', 449.95, NULL, 6),
       ('Jacuzzi/massagebad', 'Oppustelig spa til haven', 6995.00,
        'https://www.mspa.dk/products/mspa-bergen-udendors-spa-til-6-personer?variant=42219537105115&gad_source=1&gad_campaignid=22652296023&gbraid=0AAAAACI5MTYFsNKml33_naaLAorzAJd5Y',
        6);

-- Sofie - Konfirmation (id=7)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Guldkæde', '18K guld halskæde', 1999.00, NULL, 7),
       ('AirPods Pro', 'Trådløse høretelefoner', 1999.00, 'https://www.apple.com/dk/airpods-pro/', 7),
       ('Konfirmation klokke', 'Dansk konfirmationsgave', 299.00, NULL, 7),
       ('Smartwatch', 'Apple Watch Series 8', 5303.55,
        'https://www.csmegastore.dk/i/9271895/apple-watch-series-8-gps-cellular-45-mm-midnatsaluminium-smart-ur-med-sportsbånd-fluoroelastomer-midnat-båndstørrelse?utm_source=googlefeed&utm_medium=11114557-fritid-sport-outdoor-sport-træning-smartwatch&utm_campaign=apple&utm_content=0&gclsrc=aw.ds&gad_source=1&gad_campaignid=23085883395&gbraid=0aaaaad8z4zf71d6pywelr9hxr1wvxq6qn&fwd=1',
        7);

-- Sofie - Ferie-gadgets (id=8)
INSERT INTO wish (name, description, price, link, wishlist_id)
VALUES ('Kuffert', 'Letvægt hardcase kuffert 65L', 1399.00,
        'https://travelbetter.dk/vare/airbox-az18-kuffert-medium-65-cm/?attribute_pa_farve=graa&gad_source=1&gad_campaignid=22408884161&gbraid=0AAAAA-hZZSp942LzViVLGgm598rACF2uJ',
        8),
       ('Rejsepude', 'Memory foam nakkepude', 199.99, NULL, 8),
       ('GoPro kamera', 'Action kamera til eventyr', 3660.00,
        'https://www.elefun.dk/vare-68753/kamera-gopro-hero13-black?gad_source=1', 8),
       ('Solcreme SPF 50', 'Høj UV-beskyttelse', 149.99, NULL, 8);

-- RESERVATIONS
-- Anna har reserveret 2 af Oles ønsker
INSERT INTO reservation (user_id, wish_id)
VALUES (2, 1), -- Anna reserverede Oles fodbold
       (2, 3); -- Anna reserverede Oles bog

-- Per har reserveret 1 af Anna's ønsker
INSERT INTO reservation (user_id, wish_id)
VALUES (3, 9); -- Per reserverede Anna's yoga måtte

-- Sofie har reserveret 2 af Anna's ønsker
INSERT INTO reservation (user_id, wish_id)
VALUES (4, 12), -- Sofie reserverede Anna's champagneglas
       (4, 14); -- Sofie reserverede Anna's LED-lys

-- Ole har reserveret 1 af Sofie's ønsker
INSERT INTO reservation (user_id, wish_id)
VALUES (1, 24); -- Ole reserverede Sofie's rejsepude

-- Per har reserveret 1 af Sofie's ønsker
INSERT INTO reservation (user_id, wish_id)
VALUES (3, 22); -- Per reserverede Sofie's AirPods Pro


-- WISHLIST_SHARE
-- Ole deler sine lister
-- Ole's "Fødselsdag 2024" (wishlist_id=1) deles med Anna, Per og Sofie
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (2, 1), -- Anna kan se Oles fødselsdag
       (3, 1), -- Per kan se Oles fødselsdag
       (4, 1); -- Sofie kan se Oles fødselsdag

-- Ole's "Jul 2024" (wishlist_id=2) deles kun med Anna og Sofie
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (2, 2), -- Anna kan se Oles jul
       (4, 2); -- Sofie kan se Oles jul

-- Anna deler sine lister
-- Anna's "Fødselsdag 2025" (wishlist_id=3) deles med Ole, Per og Sofie
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (1, 3), -- Ole kan se Anna's fødselsdag
       (3, 3), -- Per kan se Anna's fødselsdag
       (4, 3); -- Sofie kan se Anna's fødselsdag

-- Anna's "Bryllup - Gaver" (wishlist_id=4) deles med alle (selvfølgelig!)
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (1, 4), -- Ole kan se Anna's bryllup
       (3, 4), -- Per kan se Anna's bryllup
       (4, 4); -- Sofie kan se Anna's bryllup

-- Anna's "Hjemmet - Ønskeliste" (wishlist_id=5) deles kun med Sofie
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (4, 5); -- Sofie kan se Anna's hjemmeliste

-- Per deler sin liste
-- Per's "Julegaver 2024" (wishlist_id=6) deles med Ole og Anna (men ikke Sofie)
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (1, 6), -- Ole kan se Per's julegaver
       (2, 6); -- Anna kan se Per's julegaver

-- Sofie deler sine lister
-- Sofie's "Konfirmation 2024" (wishlist_id=7) deles med alle
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (1, 7), -- Ole kan se Sofie's konfirmation
       (2, 7), -- Anna kan se Sofie's konfirmation
       (3, 7); -- Per kan se Sofie's konfirmation

-- Sofie's "Ferie-gadgets" (wishlist_id=8) deles kun med Anna og Per
INSERT INTO wishlist_share (user_id, wishlist_id)
VALUES (2, 8), -- Anna kan se Sofie's feriegadgets
       (3, 8); -- Per kan se Sofie's feriegadgets

-- OVERSIGT
-- Ole's lister:
--   Fødselsdag 2024 → delt med: Anna, Per, Sofie
--   Jul 2024 → delt med: Anna, Sofie

-- Anna's lister:
--   Fødselsdag 2025 → delt med: Ole, Per, Sofie
--   Bryllup - Gaver → delt med: Ole, Per, Sofie
--   Hjemmet - Ønskeliste → delt med: Sofie

-- Per's lister:
--   Julegaver 2024 → delt med: Ole, Anna

-- Sofie's lister:
--   Konfirmation 2024 → delt med: Ole, Anna, Per
--   Ferie-gadgets → delt med: Anna, Per