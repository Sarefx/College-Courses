import math
import random
import string
from sympy import Point, Polygon, GeometryError



random.seed(0)

# calculate a random number where:  a <= rand < b
def rand(a, b):
    return (b-a)*random.random() + a

# Make a matrix (we could use NumPy to speed this up)
def makeMatrix(I, J, fill=0.0):
    m = []
    for i in range(I):
        m.append([fill]*J)
    return m

# our sigmoid function, tanh is a little nicer than the standard 1/(1+e^-x)
def sigmoid(x):
    return math.tanh(x)

# derivative of our sigmoid function, in terms of the output (i.e. y)
def dsigmoid(y):
    return 1.0 - y**2

class NN:
    def __init__(self, ni, nh, no):
        # number of input, hidden, and output nodes
        self.ni = ni + 1 # +1 for bias node
        self.nh = nh
        self.no = no

        # activations for nodes
        self.ai = [1.0]*self.ni
        self.ah = [1.0]*self.nh
        self.ao = [1.0]*self.no
        
        # create weights
        self.wi = makeMatrix(self.ni, self.nh)
        self.wo = makeMatrix(self.nh, self.no)
        # set them to random vaules
        for i in range(self.ni):
            for j in range(self.nh):
                self.wi[i][j] = rand(-0.2, 0.2)
        for j in range(self.nh):
            for k in range(self.no):
                self.wo[j][k] = rand(-2.0, 2.0)

        # last change in weights for momentum   
        self.ci = makeMatrix(self.ni, self.nh)
        self.co = makeMatrix(self.nh, self.no)

    def update(self, inputs):
        if len(inputs) != self.ni-1:
            raise ValueError('wrong number of inputs')

        # input activations
        for i in range(self.ni-1):
            #self.ai[i] = sigmoid(inputs[i])
            self.ai[i] = inputs[i]

        # hidden activations
        for j in range(self.nh):
            sum = 0.0
            for i in range(self.ni):
                sum = sum + self.ai[i] * self.wi[i][j]
            self.ah[j] = sigmoid(sum)

        # output activations
        for k in range(self.no):
            sum = 0.0
            for j in range(self.nh):
                sum = sum + self.ah[j] * self.wo[j][k]
            self.ao[k] = sigmoid(sum)

        return self.ao[:]


    def backPropagate(self, targets, N, M):
        if len(targets) != self.no:
            raise ValueError('wrong number of target values')

        # calculate error terms for output
        output_deltas = [0.0] * self.no
        for k in range(self.no):
            error = targets[k]-self.ao[k]
            output_deltas[k] = dsigmoid(self.ao[k]) * error

        # calculate error terms for hidden
        hidden_deltas = [0.0] * self.nh
        for j in range(self.nh):
            error = 0.0
            for k in range(self.no):
                error = error + output_deltas[k]*self.wo[j][k]
            hidden_deltas[j] = dsigmoid(self.ah[j]) * error

        # update output weights
        for j in range(self.nh):
            for k in range(self.no):
                change = output_deltas[k]*self.ah[j]
                self.wo[j][k] = self.wo[j][k] + N*change + M*self.co[j][k]
                self.co[j][k] = change
                #print N*change, M*self.co[j][k]

        # update input weights
        for i in range(self.ni):
            for j in range(self.nh):
                change = hidden_deltas[j]*self.ai[i]
                self.wi[i][j] = self.wi[i][j] + N*change + M*self.ci[i][j]
                self.ci[i][j] = change

        # calculate error
        error = 0.0
        for k in range(len(targets)):
            error = error + 0.5*(targets[k]-self.ao[k])**2
        return error


    def test(self, patterns):
        for p in patterns:
            answer = self.update(p[0])
            print(p[0], '->', answer)
            print("The output is " , 1 / answer[0])

    def weights(self):
        print('Input weights:')
        for i in range(self.ni):
            print(self.wi[i])
        print()
        print('Output weights:')
        for j in range(self.nh):
            print(self.wo[j])

    def train(self, patterns, iterations=2000, N=0.5, M=0.1):
        # N: learning rate
        # M: momentum factor
        for i in range(iterations):
            error = 0.0
            for p in patterns:
                inputs = p[0]
                targets = p[1]
                self.update(inputs)
                error = error + self.backPropagate(targets, N, M)
            if i % 100 == 0:
                print('error %-.5f' % error)

def demo(numberOfEdges, learningData, userData):
    # Teach network how to deduct one number from other
    pat = learningData
    # create a network with two input, two hidden, and one output nodes
    if (numberOfEdges == 1):
        entries = 1
    elif (numberOfEdges > 1):
        entries = (numberOfEdges*2) - 3
    n = NN(entries, entries * 2, 1)
    # train it with some patterns
    n.train(pat)
    # test it
    n.test(userData)

def createLearningData(numberOfEdges, numberOfEntries, minEdge, maxEdge, minAngle, maxAngle):
    #numberOfEntries = int(input("Please enter number of entries to be used for the learning data."))
    #numberOfEntries = 10
    #minRange = int(input("Please enter minumum length of any side of the polygon."))
    #maxRange = int(input("Please enter maximum length of any side of the polygon."))
    while (len(learningData) < numberOfEntries):
        #print("Number of entries so far is ",len(learningData)," and the maximum is ",numberOfEntries)
        learningPolygonData = list()
        learningPolygonArea = list()
        learningEntryData = list()
        originalLearningPolygonData = list()
        x = 0
        y = 0
        coordinate = tuple()
        angle = 0
        oldAngle = 0
        newAngle = 0
        adjustedAngle = 0
        coordinateList = list()
        flip = True
        coordinate = (x, y)
        coordinateList.append(coordinate)
        #print("Adding coordinate tuple of x = ",x," and y = ",y," to the polygon.")
        for b in range(numberOfEdges - 1):
            edge = random.uniform(minEdge, maxEdge)
            #print("Randomly generated edge of ", edge)
            inverseEdge = 1 / edge
            learningPolygonData.append(inverseEdge)
            originalLearningPolygonData.append(edge)
            if (angle is 0):
                #print("Angle is 0.")
                newX = edge
                newY = 0
            elif (angle is not 0):
                #print("Angle is NOT 0.")
                adjustedAngle = 180 - angle
                newAngle = oldAngle + adjustedAngle
                #while (newAngle > 360):
                    #newAngle - 360
                angleRadians = math.radians(newAngle)
                #print("New angle of ",newAngle," is ",angleRadians," in radians. Old angle is ",oldAngle," and generated angle is ",angle," and adjusted angle is ",adjustedAngle)
                oldAngle = newAngle
                newX = math.cos(angleRadians) * edge
                newY = math.sin(angleRadians) * edge
            #print("New x is ", newX, " and new y is ",newY)
            #print("Checking an angle of ", newAngle)
            #if (0 < newAngle <= 180):
            #    newX = 0 - newX
            #    newY = newY
            #elif (180 < newAngle <= 360):
            #    newX = newX
            #    newY = 0 - newY
            #print("Old x ",x," PlUS new x",newX)
            x = x + newX
            #print("Old y ",y," PLUS new y",newY)
            y = y + newY
            #print("Adjust coordinates are x is ",x," and y is ",y)
            if (b != numberOfEdges -2):
                angle = random.uniform(minAngle, maxAngle)
                #print("Randomly generated angle of ", angle)
                inverseAngle = 1 / angle
                learningPolygonData.append(inverseAngle)
                originalLearningPolygonData.append(angle)
            coordinate = (x, y)
            coordinateList.append(coordinate)
            #print("Adding coordinate tuple of x = ",x," and y = ",y," to the polygon.")
        #print(coordinateList)
        if (numberOfEdges == 1):
            edge = random.uniform(minEdge, maxEdge)
            inverseEdge = 1 / edge
            learningPolygonData.append(inverseEdge)
            originalLearningPolygonData.append(edge)
            circleArea = math.pow(edge, 2) * math.pi
        elif (numberOfEdges == 3):
            #print("Creating a polygon with 3 sides.")
            polygon = Polygon(coordinateList[0], coordinateList[1], coordinateList[2])
        elif (numberOfEdges == 4):
            #print("Creating a polygon with 4 sides.")
            p1, p2, p3, p4 = map(Point, coordinateList)
            try:
                polygon = Polygon(p1, p2, p3, p4)
                #print("Polygon PASSED error test.")
            except GeometryError:
                #print("Polygon FAILED error test.")
                continue
        elif (numberOfEdges == 5):
            #print("Creating a polygon with 5 sides.")
            p1, p2, p3, p4, p5 = map(Point, coordinateList)
            try:
                polygon = Polygon(p1, p2, p3, p4, p5)
                #print("Polygon PASSED error test.")
            except GeometryError:
                #print("Polygon FAILED error test.")
                continue
        elif (numberOfEdges == 6):
            #print("Creating a polygon with 6 sides.")
            p1, p2, p3, p4, p5, p6 = map(Point, coordinateList)
            try:
                polygon = Polygon(p1, p2, p3, p4, p5, p6)
                #print("Polygon PASSED error test.")
            except GeometryError:
                #print("Polygon FAILED error test.")
                continue
        elif (numberOfEdges == 7):
            #print("Creating a polygon with 7 sides.")
            p1, p2, p3, p4, p5, p6, p7 = map(Point, coordinateList)
            try:
                polygon = Polygon(p1, p2, p3, p4, p5, p6, p7)
                #print("Polygon PASSED error test.")
            except GeometryError:
                #print("Polygon FAILED error test.")
                continue
        elif (numberOfEdges == 8):
            #print("Creating a polygon with 8 sides.")
            p1, p2, p3, p4, p5, p6, p7, p8 = map(Point, coordinateList)
            try:
                polygon = Polygon(p1, p2, p3, p4, p5, p6, p7, p8)
                #print("Polygon PASSED error test.")
            except GeometryError:
                #print("Polygon FAILED error test.")
                continue
        if (numberOfEdges == 1):
            area = circleArea
            inverseArea = 1 / float(area)
        elif (numberOfEdges > 1):
            polygonArea = polygon.area
            area = polygonArea
            inverseArea = 1 / float(area)
        learningPolygonArea.append(inverseArea)
        #print(learningPolygonData)
        #print(originalLearningPolygonData)
        #print("Area of this polygon is ", float(area))
        learningEntryData.append(learningPolygonData)
        learningEntryData.append(learningPolygonArea)
        #print(learningEntryData)
        learningData.append(learningEntryData)
    return learningData

def useExistingLearningData(numberOfEdges):
    learningData = list()
    if (numberOfEdges == 1):
        learningData = [
            [[	0.434782609	,	],    [	0.06097561	]],
[[	0.357142857	,	],    [	0.04048583	]],
[[	0.303030303	,	],    [	0.029239766	]],
[[	0.263157895	,	],    [	0.021786492	]],
[[	0.227272727	,	],    [	0.016260163	]],
[[	0.204081633	,	],    [	0.013422819	]],
[[	0.178571429	,	],    [	0.010330579	]],
[[	0.153846154	,	],    [	0.007507508	]],
[[	0.128205128	,	],    [	0.005252101	]],
[[	0.111111111	,	],    [	0.00392773	]]
        ]
    elif (numberOfEdges == 3):
        learningData = [
            [[	0.175438596	,	0.015197568	,	0.15625	],    [	0.05988024	]],
[[	0.138888889	,	0.016420361	,	0.108695652	],    [	0.034602076	]],
[[	0.416666667	,	0.017006803	,	0.14084507	],    [	0.135135135	]],
[[	0.3125	,	0.013297872	,	0.15625	],    [	0.099009901	]],
[[	0.23255814	,	0.010224949	,	0.119047619	],    [	0.055865922	]],
[[	0.15625	,	0.022271715	,	0.12195122	],    [	0.052356021	]],
[[	0.113636364	,	0.02994012	,	0.185185185	],    [	0.076335878	]],
[[	0.107526882	,	0.037735849	,	0.227272727	],    [	0.10989011	]],
[[	0.14084507	,	0.00746826	,	0.454545455	],    [	0.175438596	]],
[[	0.128205128	,	0.0084246	,	0.3125	],    [	0.090909091	]]
        ]
    elif (numberOfEdges == 4):
        learningData = [
            [[	0.120481928	,	0.010460251	,	0.136986301	,	0.011695906	,	0.106382979	],       [	0.015197568	]],
[[	0.11627907	,	0.007575758	,	0.23255814	,	0.018281536	,	0.149253731	],       [	0.034602076	]],
[[	0.27027027	,	0.008183306	,	0.23255814	,	0.018050542	,	0.128205128	],       [	0.049751244	]],
[[	0.263157895	,	0.010976948	,	0.333333333	,	0.011248594	,	0.263157895	],       [	0.088495575	]],
[[	0.263157895	,	0.010976948	,	0.333333333	,	0.009832842	,	0.095238095	],       [	0.039370079	]],
[[	0.12195122	,	0.010706638	,	0.277777778	,	0.010214505	,	0.113636364	],       [	0.026666667	]],
[[	0.147058824	,	0.012970169	,	0.128205128	,	0.010604454	,	0.163934426	],       [	0.021645022	]],
[[	0.138888889	,	0.009708738	,	0.111111111	,	0.009319664	,	0.091743119	],       [	0.01010101	]],
[[	0.294117647	,	0.017793594	,	0.163934426	,	0.015625	,	0.416666667	],       [	0.085470085	]],
[[	0.094339623	,	0.00990099	,	0.086206897	,	0.021321962	,	0.11627907	],       [	0.013812155	]],
[[	0.175438596	,	0.009689922	,	0.12195122	,	0.012004802	,	0.136986301	],       [	0.018181818	]],
[[	0.23255814	,	0.008795075	,	0.133333333	,	0.017605634	,	0.12195122	],       [	0.026666667	]],
[[	0.107526882	,	0.007057163	,	0.128205128	,	0.031746032	,	0.108695652	],       [	0.027777778	]],
[[	0.120481928	,	0.074626866	,	0.117647059	,	0.005892752	,	0.204081633	],       [	0.07751938	]],
[[	0.10989011	,	0.042553191	,	0.131578947	,	0.006978367	,	0.285714286	],       [	0.055555556	]],
[[	0.12987013	,	0.026954178	,	0.142857143	,	0.007674597	,	0.2	],       [	0.03968254	]],
[[	0.133333333	,	0.020618557	,	0.147058824	,	0.007352941	,	0.104166667	],       [	0.022573363	]],
[[	0.125	,	0.015503876	,	0.14084507	,	0.008130081	,	0.131578947	],       [	0.019267823	]],
[[	0.119047619	,	0.011904762	,	0.078125	,	0.015432099	,	0.149253731	],       [	0.012886598	]],
[[	0.12345679	,	0.00746826	,	0.096153846	,	0.019607843	,	0.095238095	],       [	0.012658228	]],
[[	0.161290323	,	0.006531679	,	0.163934426	,	0.017271157	,	0.128205128	],       [	0.024271845	]],
[[	0.178571429	,	0.006064281	,	0.153846154	,	0.019120459	,	0.131578947	],       [	0.026666667	]],
[[	0.185185185	,	0.005793743	,	0.208333333	,	0.016835017	,	0.151515152	],       [	0.034246575	]],
[[	0.133333333	,	0.007917656	,	0.416666667	,	0.009363296	,	0.126582278	],       [	0.024875622	]],
[[	0.126582278	,	0.009208103	,	0.192307692	,	0.011655012	,	0.117647059	],       [	0.01996008	]],
[[	0.384615385	,	0.006920415	,	0.181818182	,	0.015503876	,	0.101010101	],       [	0.028818444	]],
[[	0.151515152	,	0.006341154	,	0.144927536	,	0.041666667	,	0.204081633	],       [	0.0625	]],
[[	0.151515152	,	0.01025641	,	0.120481928	,	0.013227513	,	0.11627907	],       [	0.017211704	]],
[[	0.138888889	,	0.008865248	,	0.166666667	,	0.008960573	,	0.11627907	],       [	0.015313936	]],
[[	0.114942529	,	0.012224939	,	0.175438596	,	0.008190008	,	0.107526882	],       [	0.015673981	]],
[[	0.119047619	,	0.013368984	,	0.133333333	,	0.00660066	,	0.117647059	],       [	0.013947001	]],
[[	0.111111111	,	0.0155521	,	0.14084507	,	0.005720824	,	0.126582278	],       [	0.016233766	]],
[[	0.105263158	,	0.012468828	,	0.149253731	,	0.007818608	,	0.09009009	],       [	0.011723329	]],
[[	0.192307692	,	0.01048218	,	0.181818182	,	0.010857763	,	0.192307692	],       [	0.03257329	]],
[[	0.238095238	,	0.010952903	,	0.172413793	,	0.011402509	,	0.15625	],       [	0.032894737	]],
[[	0.204081633	,	0.009881423	,	0.149253731	,	0.013404826	,	0.15625	],       [	0.028328612	]],
[[	0.175438596	,	0.007836991	,	0.131578947	,	0.01984127	,	0.117647059	],       [	0.024213075	]],
[[	0.102040816	,	0.009017133	,	0.153846154	,	0.013422819	,	0.084745763	],       [	0.013850416	]],
[[	0.158730159	,	0.010330579	,	0.151515152	,	0.013477089	,	0.086956522	],       [	0.019455253	]],
[[	0.138888889	,	0.016556291	,	0.153846154	,	0.00862069	,	0.128205128	],       [	0.024213075	]],
[[	0.151515152	,	0.015082956	,	0.153846154	,	0.008658009	,	0.128205128	],       [	0.023201856	]],
[[	0.138888889	,	0.01540832	,	0.144927536	,	0.00855432	,	0.136986301	],       [	0.021834061	]],
[[	0.769230769	,	0.015313936	,	0.151515152	,	0.008576329	,	0.151515152	],       [	0.042553191	]],
[[	0.588235294	,	0.01310616	,	0.142857143	,	0.01183432	,	0.135135135	],       [	0.033898305	]],
[[	0.434782609	,	0.011013216	,	0.175438596	,	0.011013216	,	0.104166667	],       [	0.029069767	]],
[[	0.23255814	,	0.034722222	,	0.2	,	0.006082725	,	0.15625	],       [	0.08	]],
[[	0.161290323	,	0.029673591	,	0.204081633	,	0.00635324	,	0.151515152	],       [	0.054054054	]],
[[	0.2	,	0.022573363	,	0.212765957	,	0.006930007	,	0.138888889	],       [	0.048309179	]],
[[	0.181818182	,	0.018867925	,	0.217391304	,	0.007518797	,	0.117647059	],       [	0.037593985	]],
[[	0.169491525	,	0.011481056	,	0.163934426	,	0.011904762	,	0.09009009	],       [	0.021645022	]],
[[	0.151515152	,	0.008503401	,	0.161290323	,	0.017513135	,	0.133333333	],       [	0.028169014	]],
[[	0.142857143	,	0.007272727	,	0.151515152	,	0.016447368	,	0.107526882	],       [	0.018903592	]],
[[	0.149253731	,	0.007022472	,	0.153846154	,	0.017301038	,	0.086206897	],       [	0.017006803	]],
[[	0.158730159	,	0.0067659	,	0.153846154	,	0.018761726	,	0.095238095	],       [	0.02	]],
[[	0.208333333	,	0.006455778	,	0.12345679	,	0.022222222	,	0.086956522	],       [	0.01980198	]],
[[	0.2	,	0.006317119	,	0.23255814	,	0.016806723	,	0.107526882	],       [	0.028248588	]],
[[	0.161290323	,	0.006161429	,	0.23255814	,	0.016313214	,	0.1	],       [	0.022573363	]],
[[	0.181818182	,	0.00591716	,	0.238095238	,	0.017452007	,	0.097087379	],       [	0.024271845	]],
[[	0.285714286	,	0.005780347	,	0.357142857	,	0.016155089	,	0.104166667	],       [	0.038022814	]],
[[	0.303030303	,	0.005627462	,	0.357142857	,	0.017182131	,	0.135135135	],       [	0.051546392	]],
[[	0.222222222	,	0.009765625	,	0.769230769	,	0.009009009	,	0.133333333	],       [	0.059171598	]],
[[	0.238095238	,	0.009578544	,	0.588235294	,	0.007867821	,	0.14084507	],       [	0.049261084	]],
[[	0.175438596	,	0.008183306	,	0.454545455	,	0.00785546	,	0.138888889	],       [	0.032154341	]],
[[	0.181818182	,	0.008183306	,	0.357142857	,	0.00630517	,	0.149253731	],       [	0.035842294	]],
[[	0.178571429	,	0.007204611	,	0.3125	,	0.007686395	,	0.158730159	],       [	0.032051282	]],
[[	0.138888889	,	0.007002801	,	0.192307692	,	0.018214936	,	0.086956522	],       [	0.020576132	]],
[[	0.119047619	,	0.007256894	,	0.277777778	,	0.017064846	,	0.087719298	],       [	0.024271845	]],
[[	0.188679245	,	0.008032129	,	0.114942529	,	0.024038462	,	0.076923077	],       [	0.020618557	]],
[[	0.212765957	,	0.008403361	,	0.103092784	,	0.031347962	,	0.12345679	],       [	0.032051282	]],
[[	0.11627907	,	0.006877579	,	0.151515152	,	0.036900369	,	0.142857143	],       [	0.044052863	]],
[[	0.12987013	,	0.00694927	,	0.151515152	,	0.026385224	,	0.131578947	],       [	0.031948882	]],
[[	0.133333333	,	0.007342144	,	0.142857143	,	0.014836795	,	0.135135135	],       [	0.019083969	]],
[[	0.158730159	,	0.008271299	,	0.136986301	,	0.007309942	,	0.212765957	],       [	0.021978022	]],
[[	0.185185185	,	0.007788162	,	0.23255814	,	0.006761325	,	0.142857143	],       [	0.027855153	]],
[[	0.151515152	,	0.012468828	,	0.142857143	,	0.008741259	,	0.37037037	],       [	0.029850746	]],
[[	0.120481928	,	0.013315579	,	0.104166667	,	0.008613264	,	0.3125	],       [	0.018248175	]],
[[	0.114942529	,	0.01345895	,	0.106382979	,	0.009191176	,	0.227272727	],       [	0.016750419	]],
[[	0.153846154	,	0.007980846	,	0.172413793	,	0.011415525	,	0.172413793	],       [	0.023529412	]],
[[	0.5	,	0.007077141	,	0.112359551	,	0.015015015	,	0.138888889	],       [	0.025906736	]],
[[	0.333333333	,	0.007220217	,	0.144927536	,	0.012953368	,	0.12987013	],       [	0.025125628	]],
[[	0.25	,	0.007722008	,	0.098039216	,	0.017825312	,	0.096153846	],       [	0.016207455	]],
[[	0.166666667	,	0.00997009	,	0.161290323	,	0.009960159	,	0.128205128	],       [	0.019762846	]],
[[	0.1	,	0.01754386	,	0.14084507	,	0.008802817	,	0.169491525	],       [	0.022522523	]],
[[	0.113636364	,	0.013003901	,	0.5	,	0.008285004	,	0.12195122	],       [	0.037593985	]],
[[	0.128205128	,	0.011709602	,	0.25	,	0.008613264	,	0.084745763	],       [	0.018691589	]],
[[	0.131578947	,	0.012019231	,	0.125	,	0.013157895	,	0.112359551	],       [	0.018903592	]],
[[	0.131578947	,	0.011918951	,	0.1	,	0.01814882	,	0.103092784	],       [	0.018691589	]],
[[	0.107526882	,	0.012562814	,	0.107526882	,	0.010416667	,	0.5	],       [	0.01953125	]],
[[	0.181818182	,	0.00923361	,	0.14084507	,	0.010649627	,	0.333333333	],       [	0.031055901	]],
[[	0.14084507	,	0.007818608	,	0.14084507	,	0.010526316	,	0.25	],       [	0.02283105	]],
[[	0.147058824	,	0.013793103	,	0.188679245	,	0.009596929	,	0.166666667	],       [	0.031948882	]],
[[	0.2	,	0.01	,	0.217391304	,	0.009560229	,	0.125	],       [	0.027027027	]],
[[	0.131578947	,	0.016447368	,	0.149253731	,	0.00770416	,	0.111111111	],       [	0.019379845	]],
[[	0.416666667	,	0.008123477	,	0.27027027	,	0.017182131	,	0.25	],       [	0.1	]],
[[	0.204081633	,	0.011286682	,	0.204081633	,	0.01261034	,	0.238095238	],       [	0.05	]],
[[	0.136986301	,	0.017857143	,	0.136986301	,	0.010373444	,	0.238095238	],       [	0.033333333	]],
[[	0.131578947	,	0.017452007	,	0.136986301	,	0.008795075	,	0.163934426	],       [	0.025	]],
[[	0.12987013	,	0.015037594	,	0.117647059	,	0.010537408	,	0.149253731	],       [	0.02	]],
[[	0.111111111	,	0.01754386	,	0.104166667	,	0.009532888	,	0.136986301	],       [	0.016666667	]],
[[	0.1	,	0.011111111	,	0.1	,	0.011111111	,	0.1	],       [	0.01	]]
        ]
    elif (numberOfEdges == 5):
        learningData = [
            [[	0.120481928	,	0.010460251	,	0.136986301	,	0.011695906	,	0.106382979, .3213, .123124	],       [	0.015197568	]]
        ]
    elif (numberOfEdges == 6):
        learningData = [
            [[	0.120481928	,	0.010460251	,	0.136986301	,	0.011695906	,	0.106382979, .23123, .4325, .2341, .32234	],       [	0.015197568	]]
        ]
    elif (numberOfEdges == 7):
        learningData = [
            [[	0.120481928	,	0.010460251	,	0.136986301	,	0.011695906	,	0.106382979, .23123, .4325, .2341, .32234, .2341, .32234	],       [	0.015197568	]]
        ]
    elif (numberOfEdges == 8):
        learningData = [
            [[	0.120481928	,	0.010460251	,	0.136986301	,	0.011695906	,	0.106382979, .23123, .4325, .2341, .32234, .2341, .32234, .2341, .32234	],       [	0.015197568	]]
        ]
    return learningData

def getUserData(numberOfEdges):
    userPolygonData = list()
    userEntryData = list()
    userData = list()
    print("Please enter your data points in following order 1st edge then 1st angle at the end of the 1st edge and so on...")
    for a in range(numberOfEdges-1):
        print("Edge #",a+1)
        edge = float(input())
        if edge is not 0:
            inverseEdge = 1. / edge
        else:
            inverseEdge = 0
        userPolygonData.append(inverseEdge)
        if (a != numberOfEdges -2 ):
            print("Angle #",a+1)
            angle = float(input())
            if angle is not 0:
                inverseAngle = 1. / angle
            else:
                inverseAngle = 0
            userPolygonData.append(inverseAngle)
    userEntryData.append(userPolygonData)
    userData.append(userEntryData)
    print(userData)
    return userData

if __name__ == '__main__':
    #numberOfEdges =  int(input("Please enter number of edges your polygon will have."))
    numberOfEdges = 4

    learningData = list()
    learningData = createLearningData(numberOfEdges, 40, 3, 7, 30, 120)
    #learningData = useExistingLearningData(numberOfEdges)

    userData = list()
   
    # Circle
    #userData = [[[1/5.26]]] # For even sided polygons
    #userData = [[[1/5]]] # Area is 78.5
    # Triangle
    #userData = [[[1/4, 1/60, 1/4]]]  # Even Sided, Area is 
    #userData = [[[1/5, 1/90, 1/5]]]  # Area is 12.5
    #userData = [[[1/8.66, 1/60, 1/8.66]]]  # Even Sided in inside circle with radius of 5
    # 4 Sided Polygon
    userData = [[[1/5, 1/90, 1/5, 1/90, 1/5]]] # Even Sided, Area is 25
    #userData = [[[1/7.071, 1/90, 1/7.071, 1/90, 1/7.071]]]  # Even Sided in inside circle with radius of 5
    # 5 Sided Polygon
    #userData = [[[1/5, 1/108, 1/5, 1/108, 1/5, 1/108, 1/5]]] # Even Sided, Area is 44
    #userData = [[[1/5.878, 1/108, 1/5.878, 1/108, 1/5.878, 1/108, 1/5.878]]]  # Even Sided in inside circle with radius of 5
    # 6 Sided Polygon
    #userData = [[[1/5, 1/120, 1/5, 1/120, 1/5, 1/120, 1/5, 1/120, 1/5]]] # Even Sided, Area is 65
    # 7 Sided Polygon
    #userData = [[[1/5, 1/129, 1/5, 1/129, 1/5, 1/129, 1/5, 1/129, 1/5, 1/129, 1/5]]] # Even Sided, Area is 92
    # 8 Sided Polygon
    #userData = [[[1/5, 1/135, 1/5, 1/135, 1/5, 1/135, 1/5, 1/135, 1/5, 1/135, 1/5, 1/135, 1/5]]] # Even Sided, Area is 120
    


    #userData = getUserData(numberOfEdges)
    
    demo(numberOfEdges, learningData, userData)
