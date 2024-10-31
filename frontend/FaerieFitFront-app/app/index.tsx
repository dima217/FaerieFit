import images from '@/constants/images';
import React from 'react';
import { Image, ImageBackground, Text, View } from 'react-native';
import Animated, { useSharedValue } from 'react-native-reanimated';
import { SafeAreaView } from 'react-native-safe-area-context';
import globalStyles from '../constants/style';
import RegestrationBlock from '@/components/RegestrationBlock';

export default function App() {
  const width = useSharedValue(100)

  return (
    <SafeAreaView style={globalStyles.SAW}>
      <Image style={globalStyles.ImageBGRegestration}
        source={images.endStrong}
        resizeMode='cover'
      >
      </Image>
      <RegestrationBlock/>
    </SafeAreaView>
  );
}

