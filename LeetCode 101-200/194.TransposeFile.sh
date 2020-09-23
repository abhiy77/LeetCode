ncols=`head -n1 file.txt | wc -w`
for i in `seq 1 $ncols`; do
    cat file.txt | awk "{ print \$$i }" | xargs
done
