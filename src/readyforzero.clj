(ns readyforzero)

(def txt1 "en3pG3+nz+A2acXKrsyDouhViP9EDQS4JQK6uJqM3rBjKEBKC3yc=AA1=LUQqRPHvQ4dopgkbb/axClP3smzVcaTkRsCqHSG5aKFQ2TbOae0t5r4nWrCVesGK1Z3yEq+dClrDwXXOiAMyW09WdCS+CaKcfu=6kv9dUFBcS4KsUIgwMiXimoBpJZSWlBzILVf4zVA=7GjRP8RXn6uKjbjAPkpFEs/mYJpeOpEnhQfPhjoscgjfL5/SQsU6+jaAf5pg9MQzZdQAEJt7Jm1541fEmnumpjmJMd/MTJ5vzBttBBA7b5rbjDX0nHdTWn8C5suYKfNyYzc6x8S6FIepoEBsMS2mKhx5BRH5jSBrYRem4iQgYARzGnCFot3jPhp3cHj7qjXBWfZZASz8YJqi2d+r393AmdGm1L9NfU2f=FJprbLwJpuE7uT7xAlQA3Ry8aHRNgNkffP29Iqb2DSoQ0PK+9LX0t37HIAhI5zvoP6b4J7yQZEQDgeNlnPQMvSjw9pLWAxQ1VUY+NMU5BLZ2Bxuma1cIsHxcx4PwHcg0u1HYPJAWM2WK=xhJP5aQSc6oNMQK4s2=6guQRVFll6rvWkXTebrdsws7m/Kpa29spUFl8XzFx0ondEMCF3byAyWj875wAI3Hn8ZY92ddTAKj0s+a4X7qSti2lA0GzePHjBjMCD5g9kZYLtB94kkbVZ6eCle/xtto4LHH8GElc5YoUi=mk3nmQ5iOL1zMWfDyRUMLq+HCXbQL9NTejNa/yTdL3sayJOlMW1T7/Jmaz1FMbfBRFzruHeMT41=Zu3nYZJ3nIP22qKrFzNkt/24RuQ+7IMVCI2ngh2Yr8qLiL7QjSThRJPxA1wIJXwR2wqGiMhOqpun4DyQ5b/fTw1eTavpbFg6+tvqS4GKOt6p=bPoTV0GHIBBlXgHF/GUss90N0mXMKKiGwHhn/kyz=FxN0j=mfQUuUQa7lrZLjr10sqflWTwskIUkp1Cd8GYU4PaeWxiMBYFne4/8gJDt+dcZj9NV1U/B1lWigh9XvX7MiDWMAPvdrnGx0kp9v9V7LaL+JAkGGpa7s+CwwVr9C6rR0KIQLa2zF23o8men71vOVBt5Nn3U6rlmU6vWTwVhYCTptD8CHjKAX0EWcWo8T=gmYotqgXdi2y/VomdXCaBFLMtiVjpyY2npHF14p9yjvX/PBV9j4utnLeEPUZW7VD7SOc2FiqAMNBrsmNDSX64mbB6Rq1Jna36n55V5yB7=hx5FjowsqlDPD/HUR+yHAqSj7f3ZBjZZonmFFqE5ffwgf385zhjRG1x9JQRXbHG8SfLekwymb6KjkpxgZC6ATsbwALgUmmZbeMQxTAqUjyJIb9Oy2QxarahyX+bl8sElnM+j/IfvMwjSfDj/OZBl6AQpbVPfFFua4s2yhziu/vom5gtY/JDUOlEaRG=WBDX=W8Tjyx/dLE4xGuj8m9OlFWnLA6V4VVBPRbd3qUlQ9mQQYcqJj8pj=AWd3v2/yLw/SRw78lrSUajrz8i0=/mnd=8rsCMIi/F4d71XkH8V6C7Sd4IEsxVHG5EPreIZOAM0ehPTyZ4VQqHoTY2yjZwpu4LwNqQ0/l8Izyh3hczpHzl8Ai/gfkLXwR159IhKVgwP0/wxzcnnD2F8dBiQGHF7XEdbRmlplyvFos0dXsWfTFfBSRXwc2BGJtKyvO3ku2WIb1EAKJBq9rGNQv=WaMUeh087HNk+c1L6TQwCPrqm/HzaRtl3t1LYm1nmFpSfpZnbVohIfuWpIhAKrKWULSiJqJeD1Wo2TzRCh5E2tfqtRdfMvaoRoXAsU8i8RKHxmHu5qG0IUAI/ux4D0W=+Hw/DYCi47I3gaMpOf2ZsJa3SKr+kk4Hp2Oou1YfHyNw4VaPEXvkw+/WjU/9qqt4GOKAlG179j3slwGcxO6zMTxd/UoLw0h1S4wTqbi27zKkYiXB8fdTvxppQ9NAkIZQJpQ10ARdKByve6wqSznbhnGGiVEGwAmhTXPZ1v0NbAY+my1747N/2RdWSsEAX9m3WBniojR4AQENeXr=GZx0WZ01LlE2qScizbxu7UuDrCQL9LxuYf1/HYYwnzIhvvrldWmwAbylRJc1VYXGLu0dhkd/dbdIHvGr9AZQ37iMicXWvd/9E3ZftMJKPA9ilvdwCW42UMcXX8VTTQVgNNPWItRGtGWesVvugY8y5T/XZ=nOgdlwUqLsWtTH13cqgCmz+UgWcGnRFxVTmL17pJ6ZKucy8AkkUYQRsITfZfqhFxKbxR+oNTDFHSrhw/ADcOmh4ZeQA0AK67gvok4H9=t=v+6vFWEnvhrfr9RiHc9yVbwBUzAYTCZk2bOz0V6telWvtnon3Qo6qZu6SzALhnnZX4UXLpuk+Jtsfuu26dEg5Hf1I1C5l3i7+Vo6gmKGbyGe/BXf3Rhp2M/uVrNczYcZaH+GdTLUmXPEf/eZ62xKBDV0eoQAAqiv4h+xXTRvfL92dqizpXm9f35upJxwWo+jmRv1XH=ZVY5ocHnPWIXrhS3xz5fSx+uB0kcMaZz1Da6EW=AUZoccRx0nWrMUCmkDBzCQDi2Z+rXgv=Gzy96BKEkdLes9qGoLQoHJjIRlIkTPGixVXTMoWsV/f=HG9Aa2450cI1RmujMFkBRsyPDn0+zL2ZvoSIOXlHhx62zET=3mdbYsBmMiqAn88jBno7GUfbQ5DQ8L695cOtaOK9UF8ICSra5UswBmvUatVwvgMcKRSNDfTnEtsYt2+KSO8P1xCvHaJ=PiN95LM6PEzaGliQwZ7Dd=LWXR0GUBqqq+TsuTxGHLxzPvm119ceAEfyF8fqP/2Fuj6snCgRl1x/mbu/xBjUjvNAUGtfgtN5p8c3YlC9JN+D=XMo8MF0wYTqsXaN1ssGdXHsU0tbl2NZHizzJ4+njTYZMqmRTZD=h6zDW3ZkcGmGG0GLuo0TuJUTmE7tKpr7Sn2rWwWksdXe3GmicdYU0Py1YMtoO6qjGpDk0rJlDCyqzCi3RfH8R2C6+2WWx1NGhzmL2n8ku=iZT2uLnLn+RaeFse38LD38TKvjrYmxZFN4fGeKSdMqK")
(def chunks		(partition 5 1 txt1))
(defn match? [a b]
  (= 4 (count (filter true? (map = a b)))))
(defn matched-col	[chk coll]
  (filter (partial match? chk) coll))
(defn q1-1 
  ([]	(q1-1 chunks))
  ([stream]
   	(let [[chk & more] stream]
      (when chk
        (let [found (matched-col chk more)]
          (if (seq found)
            [chk (first found)]
            (recur more)))))))

(def txt2 "bDq4i3eFNmjh2oMgjNsIFkRWsonRl=tz9kf8gOpED2gVQrfx49GjR9/QNqTEJkSzM30p4RfneDc7EmdusIYdxxZ8KKdND==YpLlmN/FkErS7uqVHYIyGEBIhIRX+mbg6FjVGqfYjobX3F1lSmPpLXXxhux1lV=EzIgGct9pd=ogzAdJU4/yZOj9=njfvbSo11bcE/yUDHg/J=6DAtmWt+P/VDvE4GyYHlKVGUoksn+Lzm6Y1VVF6qw=onnKZS=CQQUPeMlUGtMobJEeyIyGBMFj5kHml1waI97qgVt/yeKWSXxhJyK+As0M0UR2KL+U7klKMlWlxgbIJ2beN0gaMHbIClKrBuroo+L73CwnbFKRiyKOx8Ke=PPukm1BWYd4Do5nikrT0dgPWlmItCzyZrEiOBgBtEB9FG1qdQJud182qYU4Xwry=bR7R5PH=Npab7JQ7gY=MYHW24iw=m2+XayIachr=QVt4giclLluUEu3Dx/5y7R0GlINqoJc9O6QwEP6a9PRsdt86nZYQUF/b729lzilkM1PB8mDPACTOGobXSJJQshRQCoJoC9TX6ERou/tlMWNQTaaU0YmzIFh8t72lgOeIMu4W2S9V8Y5jO8T47ZPRGxeQDWRQlpx1tc3AC4+x2zJxZaYV6d4+rxxWgYnYC1ZwUvXNF2YLaRw7ldRXCz9/7xZ3mKBj4Ox51L3PqGXAIB+OI4pgkUc1X52tOPdRPgpsfi8wNpynfylwjITvNKq93iViQiyiEVGBgazbHQ7boh5tejStBE1SCk1fMe1=ycNoxJzhAH4x/YlQSUOz/2qkl+JxFBt8sqRYXZjZ6R=Gh87ZwS4B0Meo56/WF+40bf2mTgG05KQ/qR89NMyttHdwwnzvkZuXGrlt/yuStJaXJNkqQ5atDPWqLJy4Q9iylEdI3qmTe6Wmou/umQG7Q+aiOXorJde3Z4CzMyTYnCWvudFDZvgEZsuKRiSOurstnxFRlqVQ0LC7WRuS=qCsDcxoDT5dl9NHusV4kZ/")
(defn pick-odd [stream]
  ;; note: drawing a couple small trees make it obvious that the leaf nodes are at the odd positions
  (let [[a b & col] stream]
    (when a
      (lazy-seq (cons a (pick-odd col))))))
(defn q2-1  
  ([] (q2-1 txt2))
  ([stream]
    (let [leaf-nums	(filter #(Character/isDigit %) (pick-odd stream))
          leaf-nums	(map #(Character/getNumericValue %) leaf-nums)]
      (reduce + leaf-nums))))

(def txt3 "2298163507642079319714044011236386616537514556458624876361063538594523631728704374833046762730571781372667347996722877761242458964516235987144911867899093570411259125272325950690385718016406645948728247900092493610635939061585125579278248678382561153927262068997135688096479833275438059003000577156030985752302737572142995389102392941277376055589936729467932043612276625158946842268530893693249010877756556663809256430403075836704397788157103267683082146557414910592210694688897583745853279150372366550265606245942901619641524394840947123797093291647952437507481770581519782926025000309975240809176732086412721877283182868239907386563436552684713604652833551208756316179487399401951895977814655415305700855625446129108900687384799001387951671104621436799720362491054813946856845126233235524710982837568591533011593761372364447069814628293634127437282262501219295880363659562599465416237996647317561877859528573985271179776400465798163016446475504146022123819119158936569549701762530276146646914630937941723419963811828693735274888334852800116766879328915880099767105948195091109555590581643322251908783026670007080972249010100892419108486345305849353679974424946961324819560021379840782224833262895740825258961195814695840112138347952831118547888120194142040782810626793593")
;; Q: The following sequence of digits sums to 5824. Break up the sequence into the LARGEST number of contiguous subsequences such that the sums of each of the subsequences are equal. Enter the number of subsequences below to continue.
(def nums3 (map #(Character/getNumericValue %) txt3))
(defn sift 
  "returns zero if all the sum is equal, keeps adding if below, nil if overshot"
  [sum-chk]
  (fn [y, x]
    (if (or (not x) (not y))
      y
	    (let [sum	(+ y x)]
	      (cond
		      (< sum sum-chk)							sum
		      (= sum sum-chk) 						0
		      (> sum sum-chk)							nil)))))
(defn find-eq-sum
  "finds a list of contiguous equal sums in a stream of numbers, then return min"
  [stream]
  (apply min (remove nil?
    (for [sum			(map inc (range))
	        :let 		[all-sum (reduce + stream)]
	        :while 	(>= all-sum sum)
	        ;; chunks of equal sums, all add up to total sum (5824)
	        ;; so must be factor of total sum (5824)
	        :when 	(zero? (rem all-sum sum))]
	      (when (reduce (sift sum) stream)
	        sum)))))
(defn take-sum 
  "take the front of a stream that totals to a specified sum"
  [eq-sum stream]
  (loop	[n	1]
    (let [part	(take n stream)]
      (when (seq part)
		    (if (= (reduce + part) eq-sum)
		      part
		      (recur (inc n)))))))
(defn partition-by-sum [eq-sum stream]
  (let [part		(take-sum eq-sum stream)
        col			(drop (count part) stream)]
    (when (seq part)
      (cons part (partition-by-sum eq-sum col)))))
(defn q3-1
  ([]	(q3-1 nums3))
  ([stream]
    (count (partition-by-sum (find-eq-sum stream) stream))))
