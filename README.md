# master-fox-client-for-java
Java JSON:API client for interfacing with MasterFox

## CRNK

The client is built on top of the https://github.com/crnk-project/crnk-framework library. Which handles all of the
heavy lifting for the serialization, request making, etc.

The main units are Resources, which are the Data Transfer Objects that map
to Foodee's API. And Repositories, implement the basic CRUD operations overtop
of REST.

## Exercising

Since this is currently a work in progress, you can exercise the library by running the Exercise class.

## Terminology

Below is a description of some of the units inside of the Foodee system.

![ERD](http://www.plantuml.com/plantuml/svg/fLRRQjmm47tNLwXlROZp0IOi5BUKXMot99G-b59KUvg8NLj6bXD2st-l9SkI9SqwNk8d-ypnN2IT6NK7thHCifeUUGFgkGKgf7eGXBIiFB1xe7jPWUpe7qBey9H7rdNqlGH6hw_fszjB8Si7NhsZcyr4-JTdVe0ZVmJvNB0ErlrXuc5KQf-MbuU-_NaK9LDSD3cziM-EKTcWIvnID8gLAgV5-4AyPIXE2PdJhnr8Xugd1cAiaZhC34mBsIgees8-V_ps9goeXgRNn9pkxDk2jtshww2uK-zJXFmyTf16-295BGfH0Rej1PFLkWqiH2yvieKOLw_SAc9nvD2eCwZRvb7m4aujK_hRBNIAzP8XKV2JpRjIz0CRCvgrT8prMIywzHakqeO3_PlBsXpt5_m4L9tbVbMMP_ysgI_U3NWw5MSKPSHVjtrdx_mdAVhMo6C7zQ_bvjEm6d9wfoHlxYyTsW_7U5kb-2Z2qQ0jn8GUWhlkgWNVMVzZDXfPoa0t2vDnPpKDrHsexxi9_f4Mw6ml-TNj8NMhqHDUaVQ6EXrx3kvwj2q4MEnuhmgcTm9HLPRztJXzaqYPeJ4KUcWZ9uHcM7E48B9AIMISZ5bcng_zkhhoVTj3kbbx-YIcd0whmXLC4sz6C1tR0XTPeWWVE_EJ586yIxpqMSYaOX8RtJeYJbDRi174bpA_WCpAoCRHaziPZXZCm4TmUpr8qes_RHl2iiUma7unsDp09luc4U1sa1FJCRJ5wPnunK-uSUGaEqUjcqXj26EMXraGvpQ-cmHM-_D_)

### Client

A client is a single account in the Foodee system, a client may be made up of many teams, users, and delivery locations,
but it only has a single billing account. 

### Restaurant

A restaurant is a single vendor account, it may have multiple pickup locations, it only ever has a single menu

#### Menu 

A menu is composed of multiple groups (Appetizers, Mains etc), menu items (individual sandwich), menu option groups (select a protein), and menu option items (pick turkey).

### Order

An order is the basic unit that aggregates the items of a single delivery, they maintain a 1<>1 relationship with the following:

- Client
- Restaurant
- Menu (This will be the active menu at the time of publishing the order)

An order is a State Machine (See OrderingState for a enumeration of the valid sates).

The diagram attached below contains the state diagram and process for an order moving through foodee system.

![Order State Flow](http://www.plantuml.com/plantuml/svg/hLXDS-Cs3BthLx1xYcUoXrvwi6QSSP9DcywscyRTcVQaOIGePYEHNf9orgtptmkI-g0aodQowqic80023tWWgVqdcO4aDuLutaTAKwcZUIPfhlTHzBnc1P2pj630TLA8b6ec-3cHW8gLf5oV4xTuJgW4Uax4CmU9Gi4rJRMlwPblQS6oP4DtfN5RmbgBx696c29dd1KNiuZWRvwAee1K9nA-L4n2bZ2UYpW2djcmuYYQtrKF1LDhSctY9JOH5BESd7tY1UFWH3EYry39sUzY5bdNHk5MaP-bg3PEvQBH-HkKszxyDWW6Co4xLGVKV-soZT8vkQnOaJ7-k8zwgpRGiyySKt-29iNctrbVr_no8Pz6GcyR5y5lK3xWdrNrK3Ajuh312d4YZyOg4SOAOJPMYR9M6ZAY1VcLbUHIF2p2aT17odZG-_i5fePmwRK486jHIKLoAKgI0SqCy1D1gM5GZJuMkMGS9OkWOGROJUlH4dgpY4K3OTss7qCmpuqqZa95TFg34ew1TDLBkD0iPwwb2PIK5GRHAyk6nJ4Vy7N3vAxDUcYFF80jYjTqim6kPWD_fdzTo5U2AosnJ0gxGeUxk8l2bhvV6YWKE6QCrAyeJw68Nz6agRKe38QlwwSnGBJI8d7-nk2-eKK2yc7NiBoHl4HXQBfviDAKPrHcmP6maP1ygOI6OIijiwocyAs6KiNZgk9KMj4Io3NT7IacLZvdieo_kSn_c4XVKsMRsXjBN9yagGj-WZlVEW4QC6ikrKZX93W4w65G9u4z3AurkuT_y1WB-vn4sTB9WIMjVGZnuwYFa6-SJOol6o4oWCMahuao769QMmtAoJqeKMpXQ25gtAno6BZ3c1-SNwTWVtIUdGv_Lm7dpIBUWpz19uchpsbaE5wCOmK9ZS3WA3mWxKlgcMbbaQjEMzvkRhfhsN1gZi8C4t54m33u3crXTwfFarwpJxHvZoQzMrAe50FiVQnVeXg5EbvBNNifNMusKcpHwUMk3i6_cewQjWVBi1b7kN-79lEIyXCoZJAewFo6SRp4_mjnasohtIvXeFqWNOJUYo1y323ljN0nrG6rKtu8udthQmIaFtLz8EVU_ht9EW5eGFsqsTc1wHzIWqcO3UCEJgunFmAJAKY6KvgYop1OW-yxmmxmnfz9WtOBdmVzAU7wSDYdhKh3oVOsW9oCki7qxgDuL6IPQhP50QXtE9wSXwLIx97Z4vDjxUlIWP6k8QkAzhKmNqgpJgZsUh9HTgPawQyrTdSiVS9xlEcTs1DXUt_UZ7qxGCT-dRpHluR2BjHENoAVdVNYc9tl5yjSezMFQnbxTAqlKJVu61VF6Ea7KznfTjugLG7ckH5IsnVluAIVkwNO_wVfugR2n3g9e-wChuld7lRaJv2bkXWo1z-aBe6Vo2_cGLflSUU-Cf0xALB0KhPlz7aj8RL6t7qRQ6nMLMeqyggu67r32FEoiRn1a8wIiqQu-GwIeqqbeQCFJLDHSOqXdtJs-4pHSlU3zxmmILbXAANHBMn-LGZbyInyrvhCrIv--6egQxBu2wI8ewcBHtU9257U2oHyisWqMdQRVp6MqVweW7X4Ux-dLrLPKhbhldgP0zkiAYVk1bZSBhMtWu46lizDKaF_-9BBwEuD-oYqJD0qyP_4ntRjXaktOxFbQCVUb9fAhbEgj_eV)

## GroupOrderMember

A group order member is a single member of an organization ordering for themselves on a 'Group/Team Order'. They
may or may not be tied to a single user depending on if an order is configured to allow for Guests. A user will
have one or more group order members over the duration of heir ordering experience wiht foodee.


