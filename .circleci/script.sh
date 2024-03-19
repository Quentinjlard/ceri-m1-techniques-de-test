#!/bin/bash

# URL vers votre rapport Checkstyle XML
CHECKSTYLE_REPORT_URL="https://circleci-tasks-prod.s3.us-east-1.amazonaws.com/storage/artifacts/a26643bf-8981-4dad-8c48-7bad3b573e6e/f849c5ad-7e64-40f1-8b29-3085aa7498bc/0/target/checkstyle-result.xml?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAQVFQINEOG3VZ3R4K%2F20240319%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240319T145718Z&X-Amz-Expires=60&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEOf%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCXVzLWVhc3QtMSJGMEQCIFKgkZ9LK2R%2Fw4adOi6FLkNJnK%2FO208aXYcghLI4fNjyAiBeh0ZokVfhsZg3ERPmNmyGGWg1Kp%2FyY3fCsFNozCzmxyq0Agjw%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAMaDDA0NTQ2NjgwNjU1NiIMNORu02fco43edolLKogCrxpTYyCkZ3SAQAcrONoxG8xWYMint%2BbHbgc47eGwN%2FB8JveisiA7CTCJUmgpyjW6Phd0ZniBijasp1gig5NhC5OAcfRaySzjR8NhyFsUWvYXattK4VL3Wiyua%2BzJdZdqejr188CR%2FnJRwFwqHyiKRNiA4bSf3oJnmyysQaSVZhipR2kWVEcCvOH2%2BTS4nHm%2F4uuNFix5TPa5PC6LJqNY6t8RezV%2BponxXYWt%2FVqNA76CW9g%2Bm%2BtSg1Yj9NErjooxUByu1gMo023qfpG8glbID1i%2B2PtB%2FIYqWZgzU9VZqr6SC2oC7rHID7jVowT%2FD4nMi3v7bkfbnoNtLFvCUd2JmGc110GxVPKnMJPJ5q8GOp4B0%2Fsjym48ewAxGsNb1%2Bl%2FAgqZiINgoJidyyWJH3TomhC3U3r4Vxkn%2BVH7VrqgwHYwb86trnWA9QT7lim4chTArde1dshd8uuzoPDZpxIa95G%2FLefr33X1nGxrPdFuX7VJ3v7iEW%2FRRHn%2BVy3n7Y8GsDSm5ry5YYvX1lYgRSKJMCwDgcuIqduaLKGbWzaE1UTxogyLdaS8sHDreh3GadU%3D&X-Amz-SignedHeaders=host&x-id=GetObject&X-Amz-Signature=d94f8989257c383bbfdf89f2c7ae6f0050ade3214a8f55f1450661766fc8991b"

# Vérifier l'état du rapport Checkstyle
# Vous devez implémenter cette logique en fonction de la structure de votre rapport Checkstyle XML
checkstyle_status=$(curl -s "$CHECKSTYLE_REPORT_URL" | grep "<error " | wc -l)

# Générer le badge Markdown en fonction de l'état du rapport Checkstyle
if [ "$checkstyle_status" -eq 0 ]; then
    badge="[![Checkstyle](https://img.shields.io/badge/Checkstyle-passing-brightgreen)]($CHECKSTYLE_REPORT_URL)"
else
    badge="[![Checkstyle](https://img.shields.io/badge/Checkstyle-failing-red)]($CHECKSTYLE_REPORT_URL)"
fi

# Mettre à jour le fichier README.md avec le badge
sed -i "s/\[Checkstyle\].*/$badge/" README.md
