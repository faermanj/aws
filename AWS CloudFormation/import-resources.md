# CloudFormation Resource Import

- Create a new stack importing existing resources.
- Import existing resources in an already created stack.
- Migrate resources across stacks.
- Remediate a detected drift.
- Refactor nested stacks by deleting children stacks from one parent and then importing them into another parent stack.

https://aws.amazon.com/blogs/aws/new-import-existing-resources-into-a-cloudformation-stack/

# Create "existing" Resources

aws s3 mb s3://existing-bucket-333
# arn:aws:s3:::existing-bucket-333

aws dynamodb create-table \
    --table-name ExistingTable333 \
    --attribute-definitions \
        AttributeName=Id,AttributeType=S \
    --key-schema \
        AttributeName=Id,KeyType=HASH \
    --billing-mode PAY_PER_REQUEST
# arn:aws:dynamodb:eu-west-1:053081517504:table/ExistingTable333

